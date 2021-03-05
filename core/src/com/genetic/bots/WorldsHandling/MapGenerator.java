package com.genetic.bots.WorldsHandling;

import com.badlogic.gdx.maps.Map;
import com.genetic.bots.Config;
import com.genetic.bots.WorldsHandling.Cell;

import java.util.Random;

public class MapGenerator {
    float walls, humans, fire;
    Random random = new Random();

    public MapGenerator(float walls, float humans, float fire) {
        this.walls = walls;
        this.humans = humans;
        this.fire = fire;
    }

    public Cell[][] generateMap() {
        Cell[][] cells = new Cell[Config.MAP_WIDTH][Config.MAP_HEIGHT];
        for (int i = 0; i < Config.MAP_WIDTH; i++) {
            for (int j = 0; j < Config.MAP_HEIGHT; j++) {
                cells[i][j] = new Cell(Cell.TYPE_NOTHING,i,j);
            }
        }

        // Default walls
        for (int i = 0; i < Config.MAP_WIDTH; i++) {
            cells[i][0] = new Cell(Cell.TYPE_WALL,i,0);
        }

        for (int i = 0; i < Config.MAP_WIDTH; i++) {
            cells[i][Config.MAP_HEIGHT-1] = new Cell(Cell.TYPE_WALL,i,Config.MAP_HEIGHT-1);
        }

        for (int i = 0; i < Config.MAP_HEIGHT; i++) {
            cells[0][i] = new Cell(Cell.TYPE_WALL,0,i);
        }
        for (int i = 0; i < Config.MAP_HEIGHT; i++) {
            cells[Config.MAP_WIDTH-1][i] = new Cell(Cell.TYPE_WALL,Config.MAP_WIDTH-1,i);
        }

        cells = addWalls(cells);
        cells = addHumans(cells);
        cells = addFire(cells);

        return cells;
    }

    private Cell[][] addWalls(Cell[][] map) {
        int wallsToAdd = ((int) ((Config.MAP_WIDTH * Config.MAP_HEIGHT) * walls));

        int order = 0;
        if(order<=wallsToAdd) {
            short nX;
            short nY;
            for (int i = order; i < wallsToAdd; i++) {
                do {
                    nX = (short) random.nextInt(Config.MAP_WIDTH);
                    nY = (short) random.nextInt(Config.MAP_HEIGHT);
                } while (map[nX][nY].getContent()!=Cell.TYPE_NOTHING);
                map[nX][nY].update(Cell.TYPE_WALL);
                order++;
            }
        }

        return map;
    }

    private Cell[][] addHumans(Cell[][] map) {
        int humansToAdd = ((int) ((Config.MAP_WIDTH * Config.MAP_HEIGHT) * humans));
        int order = 0;
        if(order<=humansToAdd) {
            short nX;
            short nY;
            for (int i = order; i < humansToAdd; i++) {
                do {
                    nX = (short) random.nextInt(Config.MAP_WIDTH);
                    nY = (short) random.nextInt(Config.MAP_HEIGHT);
                } while (map[nX][nY].getContent()!=Cell.TYPE_NOTHING);
                map[nX][nY].update(Cell.TYPE_HUMAN);
                order++;
            }
        }

        return map;
    }

    private Cell[][] addFire(Cell[][] map) {
        int fireToAdd = ((int) ((Config.MAP_WIDTH * Config.MAP_HEIGHT) * fire));

        int order = 0;
        if(order<=fireToAdd) {
            short nX;
            short nY;
            for (int i = order; i < fireToAdd; i++) {
                do {
                    nX = (short) random.nextInt(Config.MAP_WIDTH);
                    nY = (short) random.nextInt(Config.MAP_HEIGHT);
                } while (map[nX][nY].getContent()!=Cell.TYPE_NOTHING);
                map[nX][nY].update(Cell.TYPE_FIRE);
                order++;
            }
        }

        return map;
    }
}
