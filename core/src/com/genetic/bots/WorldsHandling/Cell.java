package com.genetic.bots.WorldsHandling;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Disposable;
import com.genetic.bots.BotsHandling.Bot;
import com.genetic.bots.Paint;

public class Cell {
    /* Types: 0 - nothing
              1 - fire
              2 - wall
              3 - human
              4 - bot
    */
    private static Texture fire, wall, human, bot, grid, glow;
    public static final byte TYPE_NOTHING = 0;
    public static final byte TYPE_FIRE = 1;
    public static final byte TYPE_WALL = 2;
    public static final byte TYPE_HUMAN = 3;
    public static final byte TYPE_BOT = 4;
    public static final float CELL_SIZE;

    private byte content;
    private int x, y;
    private Bot botInCell;



    static {
        CELL_SIZE = Gdx.graphics.getWidth()/53.333333f;

        fire = new Texture(Gdx.files.internal("fire.png"));
        wall = new Texture(Gdx.files.internal("wall.png"));
        human = new Texture(Gdx.files.internal("human.png"));
        bot = new Texture(Gdx.files.internal("bot.png"));
        grid = new Texture(Gdx.files.internal("grid.png"));
        glow = new Texture(Gdx.files.internal("glow.png"));
        wall = new Texture(Gdx.files.internal("wall.png"));
    }

    public static void dispose() {
        fire.dispose();
        wall.dispose();
        human.dispose();
        bot.dispose();
        grid.dispose();
        glow.dispose();
    }

    public Cell(byte defaultContent, int x, int y) {
        this.content = defaultContent;
        this.x = x;
        this.y = y;
    }

    public void render() {

        Paint.drawCell(grid,x,y,null);
        switch (content){
            case (1):
                Paint.drawCell(fire,x,y,botInCell);
                break;
            case (2):
                Paint.drawCell(wall,x,y,botInCell);
                break;
            case (3):
                Paint.drawCell(human,x,y,botInCell);
                break;
            case (4):
                try {
                    Paint.drawCell(bot, x, y,botInCell);
                }
                catch (Exception e){
                }
                break;
        }



    }

    public void update(byte state) {
        if(state == TYPE_BOT) {
            throw new RuntimeException("For bots you should use method putBot()!");
        }
        else {
            content = state;
            botInCell = null;
        }
    }

    public void putBot(Bot bot) {
        botInCell = bot;
        if(content == TYPE_HUMAN) {
            bot.addRescuedPeople();
        }
        content = TYPE_BOT;
    }

    public void removeBot() {
        botInCell = null;
        update(TYPE_NOTHING);
    }

    public byte getContent() {
        return content;
    }
}
