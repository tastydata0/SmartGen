package com.genetic.bots.WorldsHandling;

import com.badlogic.gdx.utils.Disposable;
import com.genetic.bots.*;
import com.genetic.bots.BotsHandling.Bot;
import com.genetic.bots.BotsHandling.BotFactory;
import com.genetic.bots.UI.*;

import java.util.ArrayList;
import java.util.Random;

public class World implements Disposable {

    static Random random = new Random();


    // Statement
    int width,height,botsCount;
    BotFactory botFactory;
    Bot[] bots;
    Cell[][] map;
    BotState botState;
    int steps,sleepIterations;
    float walls,people,fire;
    WorldUpdater worldUpdater;
    public Graph graph;
    public  int aliveBots,botsMemorySize,targetFF;
    public  Bot bestBot;
    String name;
    WorldsPanelItem link;
    public boolean record;

    ArrayList<Bot> newBotsArrayList;

    MapGenerator generator;

    @Override
    public void dispose() {
        //graph.dispose();
    }

    public World(Bot[] bots, int botsCount, WorldsPanelItem toLink,WorldUpdater wa,float walls,float people,float fire,String name,Graph graph,Cell[][] oldMap,int botsMemorySize, int targetFF) {
        this.walls = walls;
        this.people = people;
        this.fire = fire;
        this.name = name;
        this.botsCount = botsCount;
        this.targetFF = targetFF;
        this.botsMemorySize = botsMemorySize;


        if(bots == null) {
            botFactory = new BotFactory();
            generator = new MapGenerator(walls,people,fire);
            map = generator.generateMap();
            this.bots = generateStarterBots(botsCount,botsMemorySize);
            //botState = new BotState(this.bots);
            addBotsToMap(map, this.bots);
            this.graph = new Graph();
            worldUpdater = new WorldUpdater(this);
            worldUpdater.start();
        }
        else {
            //generator = new MapGenerator(walls,people,fire);
            for (int i = 0; i < oldMap.length; i++) {
                for (int j = 0; j < 24; j++) {
                    if(oldMap[i][j].getContent() == Cell.TYPE_BOT) {
                        oldMap[i][j].removeBot();
                    }
                }
            }
            map = oldMap;
            this.bots = bots;

            this.graph = graph;
            addBotsToMap(map, this.bots);
            //botState = new BotState(bots);
            worldUpdater = wa;
            worldUpdater.setWorld(this);
        }
        record = false;
        link = toLink;

        for (int i = 0; i < this.bots.length; i++) {
            this.bots[i].setWorldID(link.getOrder());
        }


        aliveBots = botsCount;
        bestBot = this.bots[0];
    }

    Bot[] generateStarterBots(int size, int botsMemorySize) { // Generating array of bots with random genes
        Bot[] b = new Bot[size];
        for (int i = 0; i < size; i++) {
            b[i] = botFactory.createNewBot(botsMemorySize);
        }
        return b;
    }

    public byte getCellValue(int x, int y) {
        return map[x][y].getContent();
    }
    public Cell getCell(int x, int y) {
        return map[x][y];
    }


    public void addRandomFire() {
        byte rX;
        byte rY;
        do {
            rX = (byte)random.nextInt(Config.MAP_WIDTH);
            rY = (byte)random.nextInt(Config.MAP_HEIGHT);
        } while (map[rX][rY].getContent()!=Cell.TYPE_NOTHING);
        map[rX][rY].update(Cell.TYPE_FIRE);
    }
    public void addRandomHuman() {
        byte rX;
        byte rY;
        do {
            rX = (byte)random.nextInt(Config.MAP_WIDTH);
            rY = (byte)random.nextInt(Config.MAP_HEIGHT);
        } while (map[rX][rY].getContent()!=Cell.TYPE_NOTHING);
        map[rX][rY].update(Cell.TYPE_HUMAN);
    }


    void addBotsToMap(Cell[][] map,Bot[] bots) {
        short order = 0;
        if(order<=bots.length-1) {
            byte nX;
            byte nY;
            for (int i = order; i < bots.length; i++) {
                do {
                    nX = (byte) random.nextInt(Config.MAP_WIDTH);
                    nY = (byte) random.nextInt(Config.MAP_HEIGHT);
                } while (map[nX][nY].getContent()!=Cell.TYPE_NOTHING);
                bots[order].setCoords(nX,nY);
                map[nX][nY].putBot(bots[order]);
                order++;
            }
        }
    }


    synchronized void nextPopulation() {
        BotFactory botFactory = new BotFactory();
        if(newBotsArrayList == null) {
            copyBestBots();
        }
        bubbleSorter();
        graph.add((float)bots[0].getFitnessFunc());
        for (byte i = 0; i < bots.length; i++) {
            bots[i] = botFactory.generateByBotsChromosome(newBotsArrayList.get(i));
            if(i%8==0) {
                botFactory.mutate(bots[i],Config.CHANCE_TO_MUTATE_ANOTHER_ONE_GENE);
            }
        }

        try {
            link.nextPopulation(bestBot.getFitnessFunc());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main.worlds[link.getOrder()] = new World(bots,botsCount,link,worldUpdater,walls,people,fire,name,graph,map,botsMemorySize,targetFF);

    }

    public Cell[][] getMap() {
        return map;
    }

    public void render() {

        for (int i = 0; i < Config.MAP_WIDTH; i++) {
            for (int j = 0; j < Config.MAP_HEIGHT; j++) {
                map[i][j].render();
            }
        }
        //botState.render();
        graph.render(bestBot.getFitnessFunc());



    }



    void copyBestBots() {

        Bot[] bestBots = new Bot[bots.length/8];
        bubbleSorter();

        newBotsArrayList = new ArrayList<Bot>();
        for (byte i = 0; i < bestBots.length; i++) {
            bestBots[i] = bots[i];
        }
        for (byte i = 0; i < bestBots.length*8; i++) {
            newBotsArrayList.add(bestBots[i/8]);
        }
    }

    public synchronized void update() {
        if(!link.isStart()) return;

        for (int i = 0; i < bots.length; i++) {  // Main cycle
            if(bots[i].isAlive()) {
                bots[i].makeStep();
                if(bots[i].getFitnessFunc()>bestBot.getFitnessFunc()) {
                    bestBot = bots[i];
                    if(bestBot.getFitnessFunc()>graph.bestFitnessFuncOfAllTime) {
                        record = true;
                    }
                }
            }
            if(aliveBots==botsCount/8){
                copyBestBots();
            }
            else if(aliveBots < 1) {
                nextPopulation();
                aliveBots = botsCount;
            }

        }

        steps++;

    }

    void bubbleSorter(){
        for (int out = bots.length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(bots[in+1].getFitnessFunc() > bots[in].getFitnessFunc())
                    toSwap(in, in + 1);
            }
        }
    }
    void toSwap(int i1, int i2) {
        Bot buffer = bots[i1];
        bots[i1] = bots[i2];
        bots[i2] = buffer;

    }

    public WorldsPanelItem getLink() {
        return link;
    }

    public Bot[] getBots() {
        return bots;
    }

    public String getName() {
        return name;
    }

}
