package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.genetic.bots.Main;
import com.genetic.bots.Paint;

public class BotBehavior {
    private final Texture grid,look,arrow,inspect,move,rotation;
    private static final int X = 8, Y = 220, CELL_SIZE = 65;
    private Texture drawable;
    public static int vectorX, vectorY;

    public BotBehavior() {
        grid = new Texture(Gdx.files.internal("botBehaviorGrid.png"));
        look = new Texture(Gdx.files.internal("look.png"));
        arrow = new Texture(Gdx.files.internal("arrow.png"));
        inspect = new Texture(Gdx.files.internal("inspect.png"));
        move = new Texture(Gdx.files.internal("move.png"));
        rotation = new Texture(Gdx.files.internal("rotation.png"));
    }
    public void render() {
        update();
        Paint.draw(grid,X,Y);
        Paint.draw(drawable,(X+CELL_SIZE)+(CELL_SIZE*vectorX)+1,(Y+CELL_SIZE)+(CELL_SIZE*vectorY)+1);
    }

    private void update() {
        int operation = Main.worlds[Main.getSelectedWorldID()].bestBot.getChromosome().content[WorldStatePanel.operationFlag].getValue();
        if(operation < 8) {
            drawable = move;
        }
        else if(operation < 16) {
            drawable = inspect;
        }
        else if(operation < 24) {
            drawable = look;
        }
        else if(operation < 32) {
            drawable = rotation;
        }
        else {
            drawable = arrow;
        }
    }
}
