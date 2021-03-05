package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.genetic.bots.Main;
import com.genetic.bots.Paint;
import com.genetic.bots.WorldsHandling.World;

public class WorldStatePanel extends Panel {
    private static ChromosomeDisplay chromosomeDisplay;
    private BotBehavior botBehavior;
    public static int operationFlag, operation;
    private WCStage stage;
    private Label content;
    private Button killPopulation;
    public WorldStatePanel(PanelsHandler handler) { //TODO dispose
        super(handler);
    }

    public void dispose() {
        button.dispose();
    }

    // Runs with constructor
    @Override
    void init() {
        button = new SelectButton(this,1,"CurrentWorldSelectButton.png");
        botBehavior = new BotBehavior();
        Skin skin = new Skin(Gdx.files.internal("data/skin/cloud-form-ui.json"));
        content = new Label("",skin);
        content.setX(210);
        content.setY(400);
        killPopulation = new Button(skin);
        killPopulation.add("Next\npopulation");
        killPopulation.setWidth(95);
        killPopulation.setHeight(45);
        killPopulation.addCaptureListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(killPopulation.getClickListener().isPressed())Main.worlds[Main.getSelectedWorldID()].aliveBots = 0;
                return false;
            }
        });
        killPopulation.setX(205);
        killPopulation.setY(330);
        stage = new WCStage();
        stage.addActor(content);
        stage.addActor(killPopulation);
    }

    // Draw panel content
    @Override
    void render() {

        if(Main.getSelectedWorldID() != -1) {
            if (chromosomeDisplay == null) {
                chromosomeDisplay = new ChromosomeDisplay(Main.worlds[Main.getSelectedWorldID()].getBots()[0].getChromosome().content);
            }
            operation = Main.worlds[Main.getSelectedWorldID()].bestBot.getChromosome().content[operationFlag].getValue();
            content.setText("Alive bots:\n"+Main.worlds[Main.getSelectedWorldID()].aliveBots);
            stage.draw();
            chromosomeDisplay.drawFlag();
            chromosomeDisplay.render();


            chromosomeDisplay.botInfo.setBot(Main.worlds[Main.getSelectedWorldID()].bestBot);
            chromosomeDisplay.setChromosome(Main.worlds[Main.getSelectedWorldID()].bestBot.getChromosome().content);
            botBehavior.render();
        }
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
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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
