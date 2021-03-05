package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.genetic.bots.*;
import com.genetic.bots.BotsHandling.Bot;
import com.genetic.bots.BotsHandling.Chromosome;

import java.sql.SQLException;
import java.util.List;

public class BotsList implements Disposable, InputObserver{
    private BotsListItem[] items;
    static Skin skin = new Skin(Gdx.files.internal("data/skin/cloud-form-ui.json"));
    private static final int X = -490, Y = 145;
    private Stage stage;
    private SelectBox<Show> box;
    private static final Color LIGHT_CYAN = new Color(0.89803922f,0.94901961f,1,0.9f),
                               SELECTED = Color.WHITE;
    private int choosedBotIndex = -1;
    private Table scrollTable = new Table();
    final Button setChromosome = new Button(skin);
    final Button confirmSettingChromosome = new Button(skin);
    final Button saveBot = new Button(skin);
    private Bot[] bots;
    private byte choicedOption;

    public static final byte NOTHING = -1;
    public static final byte SET_CHROMOSOME = 0;
    public static final byte SAVE = 1;

    public BotsList(final Bot[] bots) {
        this.stage = new Stage();
        InputHandler.addToObservers(this);

        choicedOption = NOTHING;

        final List<Chromosome> chromosomesList = IOHandler.readAll();

        Show[] chromosomes = new Show[chromosomesList.size()];
        for (int i = 0; i < chromosomes.length; i++) {
            chromosomes[i] = new Show(chromosomesList.get(i).name,skin);
        }

        setItems(bots);

        scrollTable.setBounds(X,Y,200,0);

        final ScrollPane scroller = new ScrollPane(scrollTable);

        scroller.setBounds(X,Y,200,0);

        final Table table = new Table();
        table.setFillParent(true);
        table.add(scroller).fill().expand();

        table.setBounds(X,Y,200,0);

        this.stage.addActor(table);

        box = new SelectBox<Show>(skin);

        Array array = new Array(chromosomes);
        box.setItems(array);
        box.setPosition(255,Y-5-setChromosome.getHeight());
        box.setMaxListCount(20);
        box.pack();
        box.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(box.getSelectedIndex()>-1) {
                    confirmSettingChromosome.setVisible(true);
                }
                return false;
            }
        });
        box.setVisible(false);
        stage.addActor(box);

        setChromosome.setWidth(160);
        setChromosome.add("Set new chromosome");
        setChromosome.setPosition(25,Y-10-setChromosome.getHeight());
        setChromosome.setVisible(false);
        setChromosome.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(setChromosome.getClickListener().isPressed()) {
                    box.setVisible(true);
                    if(choicedOption == NOTHING) {
                        choicedOption = SET_CHROMOSOME;
                    }
                }
                return false;
            }
        });
        stage.addActor(setChromosome);

        saveBot.setWidth(60);
        saveBot.add("Save");
        saveBot.setPosition(185,Y-10-saveBot.getHeight());
        saveBot.setVisible(false);
        saveBot.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(saveBot.getClickListener().isPressed()) {
                    try {
                        Chromosome ch = Main.worlds[Main.getSelectedWorldID()].getBots()[choosedBotIndex-15].getChromosome();
                        ch.name = Main.worlds[Main.getSelectedWorldID()].getBots()[choosedBotIndex-15].getName();
                        IOHandler.saveChromosome(ch);
                        chromosomesList.add(Main.worlds[Main.getSelectedWorldID()].getBots()[choosedBotIndex-15].getChromosome());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(choicedOption == NOTHING) {
                        choicedOption = SAVE;
                    }
                }
                return false;
            }
        });
        stage.addActor(saveBot);

        confirmSettingChromosome.setWidth(155+65);
        confirmSettingChromosome.add("Confirm");
        confirmSettingChromosome.setPosition(25,Y-11-confirmSettingChromosome.getHeight()*2);
        confirmSettingChromosome.setVisible(false);
        confirmSettingChromosome.addListener(new EventListener() {

            @Override
            public boolean handle(Event event) {
                if(confirmSettingChromosome.getClickListener().isPressed()) {
                    Main.worlds[Main.getSelectedWorldID()].getBots()[choosedBotIndex-15].setChromosome(chromosomesList.get(box.getSelectedIndex()));
                    setChromosome.setVisible(false);
                    confirmSettingChromosome.setVisible(false);
                    box.setVisible(false);
                    saveBot.setVisible(false);
                }
                return false;
            }
        });
        stage.addActor(confirmSettingChromosome);
    }

    public void setItems(Bot[] bots) {
        this.bots = bots;
        scrollTable.reset();
        for (int i = 0; i < 15; i++) {
            scrollTable.add(new Label("",skin));
            scrollTable.row();
        }
        for (int i = 0; i < bots.length; i++) {
            final Button b = new Button(skin);
            b.setColor(LIGHT_CYAN);
            b.add(bots[i].getName());
            b.addCaptureListener(new EventListener() {
                @Override
                public boolean handle(Event event) {
                    if(b.getClickListener().isPressed()) {
                        for (int j = 0; j < scrollTable.getChildren().size; j++) {
                            scrollTable.getChildren().get(j).setColor(LIGHT_CYAN);
                        }
                        b.setColor(SELECTED);
                        setChromosome.setVisible(true);
                        saveBot.setVisible(true);
                        choosedBotIndex = scrollTable.getChildren().indexOf(b,true);
                    }
                    return false;
                }
            });
            scrollTable.add(b);
            scrollTable.row();
        }
    }

    public Bot[] getItems() {
        return bots;
    }

    public void updateChromosomes() {

    }

    public void render() {
        stage.act();
        stage.draw();
    }


    /**
     * Releases all resources of this object.
     */
    @Override
    public void dispose() {
        for (int i = 0; i < items.length; i++) {
            items[i].dispose();
        }
        stage.dispose();
    }

    class BotsListItem implements Disposable {
        private Bot bot;

        public BotsListItem(Bot bot) {
            this.bot = bot;

           // Label name =
        }



        /**
         * Releases all resources of this object.
         */
        @Override
        public void dispose() {
            stage.dispose();
        }
    }

    /**
     * Called when a key was pressed
     *
     * @param keycode one of the constants in {@link Input.Keys}
     * @return whether the input was processed
     */
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    /**
     * Called when a key was released
     *
     * @param keycode one of the constants in {@link Input.Keys}
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
     * Called when the screen was touched or a mouse button was pressed. The button parameter will be {@link Input.Buttons#LEFT} on iOS.
     *
     * @param screenX The x coordinate, origin is in the upper left corner
     * @param screenY The y coordinate, origin is in the upper left corner
     * @param pointer the pointer for the event.
     * @param button  the button
     * @return whether the input was processed
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        stage.touchDown(screenX,Gdx.graphics.getHeight()-screenY,pointer,button);
        return false;
    }

    /**
     * Called when a finger was lifted or a mouse button was released. The button parameter will be {@link Input.Buttons#LEFT} on iOS.
     *
     * @param screenX
     * @param screenY
     * @param pointer the pointer for the event.
     * @param button  the button
     * @return whether the input was processed
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        stage.touchUp(screenX,Gdx.graphics.getHeight()-screenY,pointer,button);
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
        stage.touchDragged(screenX,Gdx.graphics.getHeight()-screenY,pointer);
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
        stage.mouseMoved(screenX,Gdx.graphics.getHeight()-screenY);
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
        stage.scrolled(amount);
        return false;
    }

}
