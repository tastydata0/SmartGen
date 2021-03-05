package com.genetic.bots.UI;

import com.genetic.bots.Main;

import java.sql.SQLException;
import java.util.Arrays;

public class BotsPanel extends Panel {
    BotsList botsList;
    public BotsPanel(PanelsHandler handler) {
        super(handler);
    }

    // Restores used memory
    public void dispose() {
        button.dispose();
    }

    // Runs with constructor
    @Override
    void init() {
        button = new SelectButton(this,2,"BotsSelectButton.png");
    }

    @Override
    void select() {
        super.select();
        botsList.setItems(Main.worlds[Main.getSelectedWorldID()].getBots());
    }

    public void setBotsList(BotsList botsList) {
        this.botsList = botsList;
    }

    public BotsList getBotsList() {
        return botsList;
    }

    // Draw panel content
    @Override
    void render() {
        if (botsList != null) {
            botsList.render();
        }
        else {
            if(Main.getSelectedWorldID()!=-1) {
                botsList = new BotsList(Main.worlds[Main.getSelectedWorldID()].getBots());
            }
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
