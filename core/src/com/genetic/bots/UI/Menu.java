package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Disposable;
import com.genetic.bots.Config;
import com.genetic.bots.Main;
import com.genetic.bots.Paint;

public class Menu implements Disposable {
    Slider speed;
    Texture titleScreen;
    Label speedLabel,javaHeap;
    UIStage stage;
    Main main;
    boolean click;
    int timer = 0;

    @Override
    public void dispose() {
        stage.dispose();
    }
    public Menu(final Main main) {
        FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("9522.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 14;
        parameter.color = Color.WHITE;
        BitmapFont font = freeTypeFontGenerator.generateFont(parameter);
        stage = new UIStage();
        this.main = main;
        Skin skin = new Skin(Gdx.files.internal("data/skin/cloud-form-ui.json"));
        titleScreen = new Texture(Gdx.files.internal("title.png"));
        speed = new Slider(0,11,1,true,skin);
        speed.setX(1180);
        speed.setY(510);

        speed.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(speed.getValue() == 11 && Config.IS_DEVELOPER_MODE_ENABLED) {
                    speedLabel.setText("Speed: "+(int)speed.getValue());
                    Config.SPEED = (int) Math.pow(2, (int) speed.getValue());
                }
                else if(speed.getValue()!=11){
                    Config.SPEED = (int) Math.pow(2, (int) speed.getValue());
                    speedLabel.setText("Speed: " + (int) speed.getValue());
                }

                return false;
            }
        });
        speedLabel = new Label("Speed: ",skin);
        speedLabel.setStyle(new Label.LabelStyle(font,Color.WHITE));
        speedLabel.setY(speed.getY()+speed.getHeight());
        speedLabel.setX(speed.getX());
        speed.setValue(Config.SPEED);
        stage.addActor(speed);
        stage.addActor(speedLabel);
        javaHeap = new Label("Java heap:\n???",skin);
        javaHeap.setWidth(100);
        javaHeap.setWrap(true);
        javaHeap.setStyle(new Label.LabelStyle(font,Color.WHITE));
        javaHeap.setX(1178);
        javaHeap.setY(680);

        stage.addActor(javaHeap);

    }

    // Draw all menu components
    public void render() {
        if(!click) Paint.draw(titleScreen,0,0);
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) click = true;
        stage.draw();
        timer++;
        if(timer>=20) {
            timer = 0;
            javaHeap.setText("Java heap: "+Gdx.app.getJavaHeap()/1024/1024+"Mb");
        }
    }
}
