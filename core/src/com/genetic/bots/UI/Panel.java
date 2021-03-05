package com.genetic.bots.UI;

import com.genetic.bots.InputObserver;

public abstract class Panel implements InputObserver {
    PanelsHandler handler;
    private boolean isSelected = false;
    SelectButton button;

    public Panel(PanelsHandler handler) {
        this.handler = handler;
        init();
    }

    // Runs with constructor
    abstract void init();

    // Draw panel content
    abstract void render();

    // Draw button (use for all panels)
    void drawButton() {
        button.render();
    }

    // Runs when user click on button
    void select() {
        handler.setSelectedPanel(this);
    }

}
