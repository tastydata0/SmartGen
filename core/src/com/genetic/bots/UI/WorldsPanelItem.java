package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.genetic.bots.*;
import com.genetic.bots.WorldsHandling.World;

import java.util.Random;

public class WorldsPanelItem implements InputObserver {
    private static final Texture createWorld, world, flash,startIcon,pause,delete,drawHint,overload,rendering,crown;
    private Texture icon;
    public int order,populations;
    private long bestFitnessFuncOfAllTime;
    private boolean visible,flashing,click,start;
    private static boolean wasSelected;
    private BitmapFont nameFont, stateFont;
    private World linkedWorld;
    int Y_OFFSET = 570;
    int X_OFFSET = 30;
    WorldCreating wc;
    long lastRenderTime;

    //TODO dispose
    // Textures initialization
    static {
        createWorld = new Texture(Gdx.files.internal("createWorld.png"));
        world = new Texture(Gdx.files.internal("worldIcon.png"));
        flash = new Texture(Gdx.files.internal("createWorldFlash.png"));
        startIcon = new Texture(Gdx.files.internal("start.png"));
        pause = new Texture(Gdx.files.internal("pause.png"));
        delete = new Texture(Gdx.files.internal("delete.png"));
        drawHint = new Texture(Gdx.files.internal("drawHint.png"));
        overload = new Texture(Gdx.files.internal("overloaded.png"));
        rendering = new Texture(Gdx.files.internal("rendering.png"));
        crown = new Texture(Gdx.files.internal("targetReached.png"));
    }

    public WorldsPanelItem(int order) {
        this.order = order;

        icon = new Texture(Gdx.files.internal("wi"+(order)+".png"));

        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 18;
        parameter.color = Color.WHITE;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("9522.ttf"));
        nameFont = generator.generateFont(parameter);
        parameter.size = 14;
        parameter.color = Color.LIGHT_GRAY;
        stateFont = generator.generateFont(parameter);
        generator.dispose();

        InputHandler.addToObservers(this);
    }

    // Draw button "Create new world" or "Short world state"
    public void render() {
        if (wc != null) {
            wc.render();
            if(wc.created) {
                Main.worlds[order] = new World(null,(int)wc.botsCount.getValue(),this,null,
                        wc.wallsDegree.getValue(),wc.humansDegree.getValue(),wc.fireDegree.getValue(),wc.name.getText(),
                        null,null,(int)wc.botsMemorySize.getValue(),(int)wc.targetScore.getValue());
                linkedWorld = Main.worlds[order];
                bestFitnessFuncOfAllTime = 0;
                populations = 0;
                wc = null;
                Main.setSelectedWorldID(order);
            }
        }
        if(order == 0 || linkedWorld!=null || Main.worlds[order-1]!=null){
            visible = true;
        }
        if(visible) {
            if(linkedWorld == null) {
                Paint.draw(createWorld,X_OFFSET,Y_OFFSET-(order*(createWorld.getHeight()+6)));
            }
            else {
                Paint.drawWorldPanelItem(world, nameFont, stateFont, linkedWorld.getName(), bestFitnessFuncOfAllTime, populations, order);
                Paint.draw(delete,X_OFFSET+createWorld.getWidth()+4,Y_OFFSET-(order*(createWorld.getHeight()+6))+4);
                if(start) {
                    Paint.draw(pause,X_OFFSET+createWorld.getWidth()+4,Y_OFFSET-(order*(createWorld.getHeight()+6))+createWorld.getHeight()/2+4);
                }
                else {
                    Paint.draw(startIcon,X_OFFSET+createWorld.getWidth()+4,Y_OFFSET-(order*(createWorld.getHeight()+6))+createWorld.getHeight()/2+4);
                }
                Paint.draw(icon,X_OFFSET+7,Y_OFFSET-(order*(createWorld.getHeight()+6))+12);
                if(Main.getSelectedWorldID() == order) {
                    Paint.draw(rendering,X_OFFSET-27+2,Y_OFFSET-(order*(createWorld.getHeight()+6))+6+24*2);
                }
                if(Main.worlds[order].record) {
                    Paint.draw(overload,X_OFFSET-27+6,Y_OFFSET-(order*(createWorld.getHeight()+6))+4+24,14,24);
                }
                if(Main.worlds[order].graph.bestFitnessFuncOfAllTime >= Main.worlds[order].targetFF) {
                    Paint.draw(crown,X_OFFSET-27,Y_OFFSET-(order*(createWorld.getHeight()+6))+4+2);
                }
            }
            if (flashing) {
                if(linkedWorld!=null && Main.getSelectedWorldID() != order && !wasSelected) {
                    Paint.draw(drawHint, X_OFFSET+createWorld.getWidth()-30, Y_OFFSET - (order * (flash.getHeight() + 6))+3);
                }
                Paint.draw(flash, X_OFFSET, Y_OFFSET - (order * (flash.getHeight() + 6)));
            }
            if (click) {
                Paint.draw(flash, X_OFFSET, Y_OFFSET - (order * (flash.getHeight() + 6)));
                click();
                click = false;
            }
        }
        lastRenderTime = System.currentTimeMillis();
    }

    // Run if user clicks on this button
    public void click() {
        if(linkedWorld == null && System.currentTimeMillis()-lastRenderTime<50) {
            if (wc == null) {
                wc = new WorldCreating(this);
            }
            wc.worldsPanelItem = this;
        }
        else if(System.currentTimeMillis()-lastRenderTime<50){
            wasSelected = true;
            Main.setSelectedWorldID(order);
        }
    }

    // Returns order
    public int getOrder() {
        return order;
    }

    // Returns true if visible
    public boolean isVisible() {
        return visible;
    }

    // Can set new bestFitnessFuncOfAllTime
    private void tryNewBestFitnessFunc(long ff) {
        if(ff>bestFitnessFuncOfAllTime) {
            bestFitnessFuncOfAllTime = ff;
        }
    }

    // Run when linked world creates new population
    public void nextPopulation(long ff) {
        tryNewBestFitnessFunc(ff);
        populations++;
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
        if(flashing) {
            click = true;
        }
        else if(linkedWorld!=null){
            Y_OFFSET = 570-(order*(createWorld.getHeight()+6));
            if(screenX>X_OFFSET+createWorld.getWidth() && screenX<X_OFFSET+createWorld.getWidth()+createWorld.getHeight()/2){
                if(screenY>Y_OFFSET && screenY<Y_OFFSET+createWorld.getHeight()/2){
                    linkedWorld.dispose();
                    linkedWorld = null;
                    Main.worlds[order] = null;
                    start = false;
                    if(Main.getSelectedWorldID() == order) {
                        Main.setSelectedWorldID(-1);
                    }
                }
                else if(screenY>Y_OFFSET+createWorld.getHeight()/2 && screenY<Y_OFFSET+createWorld.getHeight()){
                    start = !start;
                }
            }
            Y_OFFSET = 570;
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
        if(visible && screenX>X_OFFSET && screenX<X_OFFSET+createWorld.getWidth() && screenY>570-(order*(createWorld.getHeight()+6)) && screenY<570-(order*(createWorld.getHeight()+6))+createWorld.getHeight()) {
            flashing = true;
        }
        else {
            flashing = false;
        }
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

    public boolean isStart() {
        return start;
    }
}
