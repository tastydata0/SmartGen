package com.genetic.bots.UI;

public class WorldsPanel extends Panel {
    private WorldsPanelItem[] items;

    public WorldsPanel(PanelsHandler handler) {
        super(handler);
    }

    // Runs with constructor
    @Override
    void init() {
        items = new WorldsPanelItem[6];
        button = new SelectButton(this,0,"WorldsSelectButton.png");
        for (int i = 0; i < items.length; i++) {
            items[i] = new WorldsPanelItem(i);
        }
    }

    // Draw panel content
    @Override
    void render() {
        for (int i = 0; i < items.length; i++) {
            items[i].render();
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
