package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Disposable;
import com.genetic.bots.InputHandler;
import com.genetic.bots.InputObserver;
import com.genetic.bots.Paint;

public class SelectButton implements InputObserver, Disposable {

    // Constants
    private static final int SIZE_X = 80,SIZE_Y = 40,X_OFFSET = 30,Y_OFFSET = 670;
    private static final BitmapFont font;

    // State
    private Panel panel;
    private int x;
    private Texture texture;

    // Font initialization
    static {
        FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("9522.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 16;
        parameter.color = Color.WHITE;
        font = freeTypeFontGenerator.generateFont(parameter);
        freeTypeFontGenerator.dispose();
    }

    public SelectButton(Panel panel, int order, String path) {
        InputHandler.addToObservers(this);
        this.panel = panel;
        x = X_OFFSET+SIZE_X*order;
        texture = new Texture(Gdx.files.internal(path));
    }

    // Draw this button
    public void render() {
        Paint.draw(texture,x,Y_OFFSET);
    }

    /**
     * Called when a key was pressed
     *
     * @param keycode one of the constants in {@link com.badlogic.gdx.Input.Keys}
     * @return whether the input was processed
     */
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    /**
     * Called when a key was released
     *
     * @param keycode one of the constants in {@link com.badlogic.gdx.Input.Keys}
     * @return whether the input was processed
     */
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    /**
     * Called when a key was typed
     *
     * @param character The character
     * @return whether the input was processed
     */
    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    /**
     * Called when the screen was touched or a mouse button was pressed. The button parameter will be {@link com.badlogic.gdx.Input.Buttons} on iOS.
     *
     * @param screenX The x coordinate, origin is in the upper left corner
     * @param screenY The y coordinate, origin is in the upper left corner
     * @param pointer the pointer for the event.
     * @param button  the button
     * @return whether the input was processed
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(screenX>x && screenX<x+SIZE_X && screenY> Y_OFFSET && screenY<Y_OFFSET+SIZE_Y) { // OnClick method
            panel.select();
        }
        return false;
    }

    /**
     * Called when a finger was lifted or a mouse button was released. The button parameter will be {@link com.badlogic.gdx.Input.Buttons} on iOS.
     *
     * @param screenX
     * @param screenY
     * @param pointer the pointer for the event.
     * @param button  the button
     * @return whether the input was processed
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     * Called when a finger or the mouse was dragged.
     *
     * @param screenX
     * @param screenY
     * @param pointer the pointer for the event.
     * @return whether the input was processed
     */
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    /**
     * Called when the mouse was moved without any buttons being pressed. Will not be called on iOS.
     *
     * @param screenX
     * @param screenY
     * @return whether the input was processed
     */
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    /**
     * Called when the mouse wheel was scrolled. Will not be called on iOS.
     *
     * @param amount the scroll amount, -1 or 1 depending on the direction the wheel was scrolled.
     * @return whether the input was processed.
     */
    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    /**
     * Releases all resources of this object.
     */
    @Override
    public void dispose() {

    }
}
