package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.genetic.bots.*;

public class  WorldCreating implements InputObserver {
    Label botsCountLabel,botsCountMin,botsCountMax,zero1,zero2,zero3,per25_1,per25_2,per25_3,walls,humans,fires,nameLabel,
            botsMemorySizeMin,botsMemorySizeMax,botsMemorySizeLabel,targetScoreLabel;
    Slider botsCount,wallsDegree,humansDegree,fireDegree,botsMemorySize,targetScore;
    TextField name;
    Button create;
    WCStage stage;
    NoMoveWindow window;
    WorldsPanelItem worldsPanelItem;
    static float x,y;
    boolean created;

    //TODO dispose

    public WorldCreating(WorldsPanelItem wpi) {
        this.worldsPanelItem = wpi;
        InputHandler.addToObservers(this);
        stage = new WCStage(this);


        Skin skin = new Skin(Gdx.files.internal("data/skin/cloud-form-ui.json"));

        window = new NoMoveWindow("Create world ("+(wpi.getOrder()+1)+")",skin);
        //window.setColor(Color.BLACK);
        window.setSize(155,380);
        x = 304 + window.getWidth()*wpi.getOrder()*0.1f;
        window.setMovable(false);

        window.setName("Window");

        y = 789 - window.getHeight();
        window.setPosition(x,y);
        stage.addActor(window);

        name = new TextField("World "+(wpi.getOrder()+1),skin);
        name.setPosition(x+3,y+210);
        stage.addActor(name);

        nameLabel = new Label("Name:",skin);
        nameLabel.setPosition(x+3,name.getY()+name.getHeight());
        stage.addActor(nameLabel);

        botsCount = new Slider(8,96,8,false,skin);
        botsCount.setWidth(114);
        botsCount.setY(y+53);
        botsCount.setX(x+10);
        wallsDegree = new Slider(0,0.25f,0.001f,false,skin);
        wallsDegree.setWidth(114);
        wallsDegree.setY(y+160);
        wallsDegree.setX(x+10);
        wallsDegree.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                walls.setText("Walls: "+(int)(wallsDegree.getValue()*100)+"%");
                Config.DEGREE_OF_WALLS = wallsDegree.getValue();
                return false;
            }
        });

        stage.addActor(wallsDegree);
        humansDegree = new Slider(0,0.25f,0.001f,false,skin);
        humansDegree.setWidth(114);
        humansDegree.setY(y+130);
        humansDegree.setX(x+10);
        humansDegree.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                humans.setText("Ore: "+(int)(humansDegree.getValue()*100)+"%");
                Config.DEGREE_OF_HUMANS = humansDegree.getValue();
                return false;
            }
        });

        stage.addActor(humansDegree);
        fireDegree = new Slider(0,0.25f,0.001f,false,skin);
        fireDegree.setWidth(114);
        fireDegree.setY(y+100);
        fireDegree.setX(x+10);
        fireDegree.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                fires.setText("Hazards: "+(int)(fireDegree.getValue()*100)+"%");
                Config.DEGREE_OF_FIRE = fireDegree.getValue();
                return false;
            }
        });
        stage.addActor(fireDegree);

        zero1 = new Label("0",skin);
        zero1.setY(wallsDegree.getY());
        zero1.setColor(Color.WHITE);
        zero1.setX(wallsDegree.getX()-zero1.getWidth());
        stage.addActor(zero1);
        per25_1 = new Label("25%",skin);
        per25_1.setY(wallsDegree.getY());
        per25_1.setColor(Color.WHITE);
        per25_1.setX(wallsDegree.getX()+wallsDegree.getWidth());
        stage.addActor(per25_1);

        walls = new Label("Barriers: "+(int)(wallsDegree.getValue()*100)+"%",skin);
        walls.setX(wallsDegree.getX());
        walls.setColor(Color.WHITE);
        walls.setY(wallsDegree.getY()+wallsDegree.getHeight());
        stage.addActor(walls);

        zero2 = new Label("0",skin);
        zero2.setY(humansDegree.getY());
        zero2.setX(humansDegree.getX()-zero2.getWidth());
        stage.addActor(zero2);
        per25_2 = new Label("25%",skin);
        per25_2.setY(humansDegree.getY());
        per25_2.setColor(Color.WHITE);
        per25_2.setX(humansDegree.getX()+humansDegree.getWidth());
        stage.addActor(per25_2);

        humans = new Label("Ore: "+(int)(humansDegree.getValue()*100)+"%",skin);
        humans.setX(humansDegree.getX());
        humans.setY(humansDegree.getY()+humansDegree.getHeight());
        stage.addActor(humans);

        zero3 = new Label("0",skin);
        zero3.setY(fireDegree.getY());
        zero3.setColor(Color.WHITE);
        zero3.setX(fireDegree.getX()-zero3.getWidth());
        stage.addActor(zero3);
        per25_3 = new Label("25%",skin);
        per25_3.setColor(Color.WHITE);
        per25_3.setY(fireDegree.getY());
        per25_3.setX(fireDegree.getX()+fireDegree.getWidth());
        stage.addActor(per25_3);

        fires = new Label("Hazards: "+(int)(fireDegree.getValue()*100)+"%",skin);
        fires.setX(fireDegree.getX());
        fires.setColor(Color.WHITE);
        fires.setY(fireDegree.getY()+fireDegree.getHeight());
        stage.addActor(fires);

        botsCountMin = new Label("8",skin);
        botsCountMin.setY(botsCount.getY());
        botsCountMin.setColor(Color.WHITE);
        botsCountMin.setX(botsCount.getX()-botsCountMin.getWidth());
        stage.addActor(botsCountMin);
        botsCountMax = new Label("96",skin);
        botsCountMax.setY(botsCount.getY());
        botsCountMax.setColor(Color.WHITE);
        botsCountMax.setX(botsCount.getX()+botsCount.getWidth());
        stage.addActor(botsCountMax);

        botsCount.setValue(Config.BOTS_COUNT);
        botsCount.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Config.BOTS_COUNT = (int)botsCount.getValue();
                botsCountLabel.setText("Bots count: "+(int)botsCount.getValue());
                return false;
            }
        });

        stage.addActor(botsCount);

        botsCountLabel = new Label("Bots count: "+(int)botsCount.getValue(),skin);
        botsCountLabel.setX(botsCount.getX());
        botsCountLabel.setY(botsCount.getY()+botsCount.getHeight());
        stage.addActor(botsCountLabel);


        create = new Button(skin);
        create.add("Create");
        create.setSize(window.getWidth()-6,40);
        create.setPosition(x+3,y-60);
        create.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(create.getClickListener().isPressed()) created = true;
                return false;
            }
        });
        stage.addActor(create);

        wallsDegree.setValue(Config.DEGREE_OF_WALLS);
        humansDegree.setValue(Config.DEGREE_OF_HUMANS);
        fireDegree.setValue(Config.DEGREE_OF_FIRE);

        botsMemorySize = new Slider(8,128,8,false,skin);
        botsMemorySize.setWidth(114);
        botsMemorySize.setY(y+25);
        botsMemorySize.setX(x+10);
        botsMemorySize.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                botsMemorySizeLabel.setText("Bots memory: "+(int)botsMemorySize.getValue());
                return false;
            }
        });

        stage.addActor(botsMemorySize);

        botsMemorySizeMin = new Label("8",skin);
        botsMemorySizeMin.setY(botsMemorySize.getY());
        botsMemorySizeMin.setX(botsMemorySize.getX()-botsMemorySizeMin.getWidth());
        stage.addActor(botsMemorySizeMin);

        botsMemorySizeMax = new Label("128",skin);
        botsMemorySizeMax.setY(botsMemorySize.getY());
        botsMemorySizeMax.setX(botsMemorySize.getX()+botsMemorySize.getWidth());
        stage.addActor(botsMemorySizeMax);

        botsMemorySizeLabel = new Label("Bots memory: "+(int)botsMemorySize.getValue(),skin);
        botsMemorySizeLabel.setX(botsMemorySize.getX());
        botsMemorySizeLabel.setY(botsMemorySize.getY()+botsMemorySize.getHeight());
        stage.addActor(botsMemorySizeLabel);
        botsMemorySize.setValue(Config.BOTS_MEMORY_SIZE);

        targetScore = new Slider(500,1000000,100,false,skin);
        targetScore.setWidth(144);
        targetScore.setY(y-5);
        targetScore.setX(x+5);
        targetScore.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                targetScoreLabel.setText("Target FF: "+ TextFormat.coolFormat((long)targetScore.getValue()));
                return false;
            }
        });
        stage.addActor(targetScore);

        targetScoreLabel = new Label("Target FF: "+TextFormat.coolFormat((long)targetScore.getValue()),skin);
        targetScoreLabel.setX(targetScore.getX());
        targetScoreLabel.setY(targetScore.getY()+targetScore.getHeight());
        stage.addActor(targetScoreLabel);

        targetScore.setValue(30000);
    }
    public void render() {
        Paint.drawWindow(window);
        stage.draw();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY,     int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
