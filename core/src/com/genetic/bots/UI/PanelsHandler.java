package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.genetic.bots.InputHandler;
import com.genetic.bots.InputObserver;
import com.genetic.bots.Main;
import com.genetic.bots.Paint;

public class PanelsHandler implements InputObserver {   // Main panels class
    private static Panel worldsPanel;
    private static Panel worldStatePanel;
    private static Panel botsPanel;
    private static Panel selectedPanel;
    private Main main;
    private Texture header;
//Todo dispose
    public PanelsHandler(Main main) {
        this.main = main;
        InputHandler.addToObservers(this); // Getting input events

        worldsPanel = new WorldsPanel(this);
        worldStatePanel = new WorldStatePanel(this);
        botsPanel = new BotsPanel(this);
        selectedPanel = worldsPanel;
        header = new Texture(Gdx.files.internal("header.png"));
    }

    // Draw all buttons and render() current panel
    public void render() {
        selectedPanel.render();
        if(selectedPanel.equals(botsPanel)) {
            Paint.draw(header,0,640);
        }
        worldsPanel.drawButton();
        worldStatePanel.drawButton();
        botsPanel.drawButton();
        selectedPanel.drawButton();
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

    // Runs when user clicks on the screen
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        worldsPanel.touchDown(screenX,screenY,pointer,button);
        worldStatePanel.touchDown(screenX,screenY,pointer,button);
        botsPanel.touchDown(screenX,screenY,pointer,button);
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

    // Sets new panel-to-render
    public void setSelectedPanel(Panel selectedPanel) {
        this.selectedPanel = selectedPanel;
    }

    // Returns object of Main.class
    public Main getMain() {
        return main;
    }

    public static Panel getWorldsPanel() {
        return worldsPanel;
    }

    public static Panel getWorldStatePanel() {
        return worldStatePanel;
    }

    public static Panel getBotsPanel() {
        return botsPanel;
    }

    public static Panel getSelectedPanel() {
        return selectedPanel;
    }
}
