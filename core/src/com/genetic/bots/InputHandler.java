package com.genetic.bots;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;

public class InputHandler implements InputProcessor {
    private int screenHeight;

    // All observers take input info
    private static ArrayList<InputObserver> observers = new ArrayList<InputObserver>();

    public InputHandler() {
        Gdx.input.setInputProcessor(this);
        screenHeight = Gdx.graphics.getHeight();
    }

    // Add T extends InputProcessor to observers
    public static void addToObservers(InputObserver observer){
        observers.add(observer);
    }

    // Remove T extends InputProcessor from observers
    public static void removeFromObservers(InputObserver observer){
        observers.remove(observer);
    }

    // Remove all observers
    public static void clear() {
        observers = new ArrayList<InputObserver>();
    }

    @Override
    public boolean keyDown(int keycode) {
        try {
            for (InputObserver io : observers) {
                io.keyDown(keycode);
            }
        }
        catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        try {
            for (InputObserver io : observers) {
                io.keyUp(keycode);
            }
        }
        catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        try {
            for (InputObserver io : observers) {
                io.keyTyped(character);
            }
        }
        catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        try {
            for (InputObserver io : observers) {
                io.touchDown(screenX, screenHeight - screenY, pointer, button);
            }
        }
        catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        try {
            for (InputObserver io : observers) {
                io.touchUp(screenX, screenHeight - screenY, pointer, button);
            }
        }
        catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        try {
            for (InputObserver io : observers) {
                io.touchDragged(screenX, screenHeight - screenY, pointer);
            }
        }
        catch (Exception e) {

        }

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        try {
            for (InputObserver io : observers) {
                io.mouseMoved(screenX, screenHeight - screenY);
            }
        }
        catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        try {
            for (InputObserver io : observers) {
                io.scrolled(amount);
            }
        }
        catch (Exception e) {

        }
        return false;
    }
}
