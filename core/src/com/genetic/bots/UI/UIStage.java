package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.genetic.bots.InputHandler;
import com.genetic.bots.InputObserver;
import com.genetic.bots.Paint;

public class UIStage extends Stage implements InputObserver {
    int mouseY;
    public UIStage() {
        super();
        InputHandler.addToObservers(this);
    }

    public UIStage(Viewport viewport) {
        super(viewport);
    }

    public UIStage(Viewport viewport, Batch batch) {
        super(viewport, batch);
    }

    @Override
    public void draw() {
        if(mouseY<Paint.Y_ALIGNMENT || true) {
            super.draw();
        }
    }

    @Override
    public void act() {
        super.act();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return super.touchDown(screenX, Gdx.graphics.getHeight()-screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, Gdx.graphics.getHeight()-screenY, pointer);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return super.touchUp(screenX, Gdx.graphics.getHeight()-screenY, pointer, button);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        mouseY = screenY;
        return super.mouseMoved(screenX, screenY);
    }

    @Override
    public boolean scrolled(int amount) {
        return super.scrolled(amount);
    }

    @Override
    public boolean keyDown(int keyCode) {
        return super.keyDown(keyCode);
    }

    @Override
    public boolean keyUp(int keyCode) {
        return super.keyUp(keyCode);
    }

    @Override
    public boolean keyTyped(char character) {
        if (((int) character) >= 48 && ((int) character) <= 57 || ((int) character) == 8) {
            return super.keyTyped(character);
        }
        return false;
    }

    @Override
    public void addTouchFocus(EventListener listener, Actor listenerActor, Actor target, int pointer, int button) {
        super.addTouchFocus(listener, listenerActor, target, pointer, button);
    }

    @Override
    public void removeTouchFocus(EventListener listener, Actor listenerActor, Actor target, int pointer, int button) {
        super.removeTouchFocus(listener, listenerActor, target, pointer, button);
    }

    @Override
    public void cancelTouchFocus(Actor actor) {
        super.cancelTouchFocus(actor);
    }

    @Override
    public void cancelTouchFocus() {
        super.cancelTouchFocus();
    }

    @Override
    public void cancelTouchFocusExcept(EventListener exceptListener, Actor exceptActor) {
        super.cancelTouchFocusExcept(exceptListener, exceptActor);
    }

    @Override
    public void addActor(Actor actor) {
        super.addActor(actor);
    }

    @Override
    public void addAction(Action action) {
        super.addAction(action);
    }

    @Override
    public Array<Actor> getActors() {
        return super.getActors();
    }

    @Override
    public boolean addListener(EventListener listener) {
        return super.addListener(listener);
    }

    @Override
    public boolean removeListener(EventListener listener) {
        return super.removeListener(listener);
    }

    @Override
    public boolean addCaptureListener(EventListener listener) {
        return super.addCaptureListener(listener);
    }

    @Override
    public boolean removeCaptureListener(EventListener listener) {
        return super.removeCaptureListener(listener);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void unfocusAll() {
        super.unfocusAll();
    }

    @Override
    public void unfocus(Actor actor) {
        super.unfocus(actor);
    }

    @Override
    public boolean setKeyboardFocus(Actor actor) {
        return super.setKeyboardFocus(actor);
    }

    @Override
    public Actor getKeyboardFocus() {
        return super.getKeyboardFocus();
    }

    @Override
    public boolean setScrollFocus(Actor actor) {
        return super.setScrollFocus(actor);
    }

    @Override
    public Actor getScrollFocus() {
        return super.getScrollFocus();
    }

    @Override
    public Batch getBatch() {
        return super.getBatch();
    }

    @Override
    public Viewport getViewport() {
        return super.getViewport();
    }

    @Override
    public void setViewport(Viewport viewport) {
        super.setViewport(viewport);
    }

    @Override
    public float getWidth() {
        return super.getWidth();
    }

    @Override
    public float getHeight() {
        return super.getHeight();
    }

    @Override
    public Camera getCamera() {
        return super.getCamera();
    }

    @Override
    public Group getRoot() {
        return super.getRoot();
    }

    @Override
    public void setRoot(Group root) {
        super.setRoot(root);
    }

    @Override
    public Actor hit(float stageX, float stageY, boolean touchable) {
        return super.hit(stageX, stageY, touchable);
    }

    @Override
    public Vector2 screenToStageCoordinates(Vector2 screenCoords) {
        return super.screenToStageCoordinates(screenCoords);
    }

    @Override
    public Vector2 stageToScreenCoordinates(Vector2 stageCoords) {
        return super.stageToScreenCoordinates(stageCoords);
    }

    @Override
    public Vector2 toScreenCoordinates(Vector2 coords, Matrix4 transformMatrix) {
        return super.toScreenCoordinates(coords, transformMatrix);
    }

    @Override
    public void calculateScissors(Rectangle localRect, Rectangle scissorRect) {
        super.calculateScissors(localRect, scissorRect);
    }

    @Override
    public void setActionsRequestRendering(boolean actionsRequestRendering) {
        super.setActionsRequestRendering(actionsRequestRendering);
    }

    @Override
    public boolean getActionsRequestRendering() {
        return super.getActionsRequestRendering();
    }

    @Override
    public Color getDebugColor() {
        return super.getDebugColor();
    }

    @Override
    public void setDebugInvisible(boolean debugInvisible) {
        super.setDebugInvisible(debugInvisible);
    }

    @Override
    public void setDebugAll(boolean debugAll) {
        super.setDebugAll(debugAll);
    }

    @Override
    public boolean isDebugAll() {
        return super.isDebugAll();
    }

    @Override
    public void setDebugUnderMouse(boolean debugUnderMouse) {
        super.setDebugUnderMouse(debugUnderMouse);
    }

    @Override
    public void setDebugParentUnderMouse(boolean debugParentUnderMouse) {
        super.setDebugParentUnderMouse(debugParentUnderMouse);
    }

    @Override
    public void setDebugTableUnderMouse(Table.Debug debugTableUnderMouse) {
        super.setDebugTableUnderMouse(debugTableUnderMouse);
    }

    @Override
    public void setDebugTableUnderMouse(boolean debugTableUnderMouse) {
        super.setDebugTableUnderMouse(debugTableUnderMouse);
    }

    @Override
    public void dispose() {
        try {
            super.dispose();
        } catch (Exception e) {

        }
    }

    @Override
    protected boolean isInsideViewport(int screenX, int screenY) {
        return super.isInsideViewport(screenX, screenY);
    }
}
