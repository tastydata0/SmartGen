package com.genetic.bots;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;
import com.genetic.bots.UI.UIStage;

import java.util.ArrayList;

public class Graph implements Disposable {
    public static final int WIDTH = 1175, HEIGHT = 105,X = 1175-WIDTH,Y = 0;
    private static Texture graphElement,currentState,overloaded;
    private ArrayList<Float> bestFitnessFuncPerPopulation = new ArrayList<Float>();
    public long bestFitnessFuncOfAllTime = 1;
    private UIStage stage;
    private Label max,min;

    // Restores used memory
    @Override
    public void dispose() {
       // graphElement.dispose();
       // stage.dispose();
    }

    static {
        // Creating graph element
        Pixmap gp = new Pixmap(1,1,Pixmap.Format.RGBA4444);
        gp.setColor(new Color(0.8f,0.8f,0.8f,0.6f));
        gp.fill();
        graphElement = new Texture(gp);

        Pixmap cs = new Pixmap(10,1,Pixmap.Format.RGBA4444);
        cs.setColor(new Color(0.01f,1f,0.1f,0.6f));
        cs.fill();
        currentState = new Texture(cs);

        cs.dispose();
        gp.dispose();

        overloaded = new Texture("overloaded.png");
    }

    public Graph() {

        for (int i = 0; i < WIDTH; i++) {
            add(0);
        }

        stage = new UIStage();
        Skin skin = new Skin(Gdx.files.internal("data/skin/cloud-form-ui.json"));
        FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("9522.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 14;
        parameter.color = Color.WHITE;
        BitmapFont font = freeTypeFontGenerator.generateFont(parameter);
        freeTypeFontGenerator.dispose();
        min = new Label("0",skin);
        min.setX(X-min.getWidth()+WIDTH-10);
        min.setY(Y);
        min.setStyle(new Label.LabelStyle(font,Color.WHITE));
        max = new Label("1",skin);
        max.setX(X-max.getWidth()+WIDTH-10);
        max.setY(Y+HEIGHT);
        max.setStyle(new Label.LabelStyle(font,Color.WHITE));
        stage.addActor(min);
        stage.addActor(max);
    }

    // Add new population result for graph
    public void add(float value) {
        if(value>bestFitnessFuncOfAllTime) {
            bestFitnessFuncOfAllTime = (int) value;
            max.setText((int)value+"");
            max.setX(X-((max.getWidth()+4)*(max.getText().length-1))+WIDTH-10);
        }
        bestFitnessFuncPerPopulation.add(value);
        if(bestFitnessFuncPerPopulation.size()>WIDTH)bestFitnessFuncPerPopulation.remove(0);
    }

    // Draw all graph elements
    public void render(long currentFF) {
        try {
            for (int i = 0; i < WIDTH; i++) {
                Paint.drawGraphElement(graphElement, i, Y, 1,bestFitnessFuncPerPopulation.get(bestFitnessFuncPerPopulation.size() - (WIDTH - i)) / bestFitnessFuncOfAllTime);
            }
            if(currentFF>bestFitnessFuncOfAllTime) {
                currentFF = bestFitnessFuncOfAllTime;
                Paint.draw(overloaded,1175+15,HEIGHT-28);

            }
            Paint.drawGraphElement(currentState,1175,Y,10,(float)currentFF/(float)bestFitnessFuncOfAllTime);
            stage.draw();
        }
        catch (Exception e){

        }

    }
}
