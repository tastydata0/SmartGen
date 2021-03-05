package com.genetic.bots;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Disposable;
import com.genetic.bots.BotsHandling.Bot;
import com.genetic.bots.UI.BotState;
import com.genetic.bots.WorldsHandling.Cell;
import com.genetic.bots.WorldsHandling.World;


public class Paint implements Disposable, InputObserver {
    private static SpriteBatch batch;
    private static Texture whiteNoise = new Texture(Gdx.files.internal("whiteNoise.png"));
    private static final float X_ALIGNMENT;
    public static final float Y_ALIGNMENT;
    private static final float Y_ALIGNMENT_SHADOW = 19;
    private static int mouseX, mouseY;
    private static boolean mouseClicked;


    public Paint() {
        batch = new SpriteBatch();
        InputHandler.addToObservers(this);
    }

    static {
        X_ALIGNMENT = (Gdx.graphics.getWidth()-48*Cell.CELL_SIZE)/8+Cell.CELL_SIZE*(48-Config.MAP_WIDTH);
        Y_ALIGNMENT = (Gdx.graphics.getHeight()-Config.MAP_HEIGHT*Cell.CELL_SIZE)/1.1f;
    }

    public static void draw(Texture texture, float x, float y) {
        batch.begin();
        batch.draw(texture,x,y);
        batch.end();
    }

    public static void draw(Texture texture,float x,float y,float sizeX,float sizeY) {
        batch.begin();
        batch.draw(texture,x,y,sizeX,sizeY);
        batch.end();
    }

    public static void drawCell(Texture texture, int x, int y,Bot bot) {
        batch.begin();
        if(bot == null) {
            batch.draw(texture, X_ALIGNMENT + x * Cell.CELL_SIZE, Y_ALIGNMENT + y * Cell.CELL_SIZE);
        }
        else if(bot.equals(Main.worlds[Main.getSelectedWorldID()].bestBot) && bot.isAlive()){
            batch.draw(texture, X_ALIGNMENT + x * Cell.CELL_SIZE, Y_ALIGNMENT + y * Cell.CELL_SIZE);
        }
        else if(bot.isAlive()){
            batch.draw(texture, X_ALIGNMENT + x * Cell.CELL_SIZE+11, Y_ALIGNMENT + y * Cell.CELL_SIZE+11,4,4);
        }
        batch.end();
    }

    public static void drawWindow(Window window) {
        batch.begin();
        window.draw(batch,1);
        batch.end();
    }

    public static void drawBotInfo(Texture texture, Texture selection ,float yOffset, BitmapFont nameFont, BitmapFont pointsFont,Bot bot) {
        float drawX = Gdx.graphics.getWidth()-(texture.getWidth()-Y_ALIGNMENT_SHADOW)-18;
        float drawY = Gdx.graphics.getHeight()-10-(yOffset+BotState.globalOffset) *((texture.getHeight()-Y_ALIGNMENT_SHADOW)+20)-texture.getHeight();
        batch.begin();
        batch.draw(texture,drawX,drawY);
        if(!bot.isAlive())batch.draw(whiteNoise,Gdx.graphics.getWidth()-(texture.getWidth()-Y_ALIGNMENT_SHADOW)-18+2,Gdx.graphics.getHeight()-10-(yOffset+BotState.globalOffset)*((texture.getHeight()-Y_ALIGNMENT_SHADOW)+20)-texture.getHeight()+(169-92));
        nameFont.draw(batch,bot.getName(),Gdx.graphics.getWidth()-(texture.getWidth()-Y_ALIGNMENT_SHADOW)-18+(texture.getWidth()-Y_ALIGNMENT_SHADOW)/2-bot.getName().length()*3.8f,Gdx.graphics.getHeight()-5-(yOffset+BotState.globalOffset)*(((texture.getHeight()-Y_ALIGNMENT_SHADOW))+20)-10);
        pointsFont.draw(batch,bot.getFitnessFuncString(),Gdx.graphics.getWidth()-(texture.getWidth()-Y_ALIGNMENT_SHADOW)-10+(texture.getWidth()-Y_ALIGNMENT_SHADOW)/2-(bot.getFitnessFuncString()).length()*3.7f,Gdx.graphics.getHeight()-5-(yOffset+BotState.globalOffset)*(((texture.getHeight()-Y_ALIGNMENT_SHADOW))+20)-108);
        pointsFont.draw(batch,bot.getHealthString(),Gdx.graphics.getWidth()-(texture.getWidth()-Y_ALIGNMENT_SHADOW)-10+(texture.getWidth()-Y_ALIGNMENT_SHADOW)/2-(bot.getHealthString()).length()*3.7f,Gdx.graphics.getHeight()-5-(yOffset+BotState.globalOffset)*(((texture.getHeight()-Y_ALIGNMENT_SHADOW))+20)-135);
        if(mouseX>=Gdx.graphics.getWidth()-(texture.getWidth()-Y_ALIGNMENT_SHADOW)-18 && mouseX<=Gdx.graphics.getWidth()-(texture.getWidth()-Y_ALIGNMENT_SHADOW)-18+texture.getWidth() &&
                mouseY>=Gdx.graphics.getHeight()-10-(yOffset+BotState.globalOffset) *((texture.getHeight()-Y_ALIGNMENT_SHADOW)+20)-texture.getHeight() &&
                mouseY<=Gdx.graphics.getHeight()-10-(yOffset+BotState.globalOffset) *((texture.getHeight()-Y_ALIGNMENT_SHADOW)+20)-texture.getHeight()+texture.getHeight()-Y_ALIGNMENT_SHADOW){
            batch.draw(selection,drawX, drawY);
        }
        batch.end();

    }

    public static void drawBotInfoForChromosome(Texture texture, float yOffset, BitmapFont nameFont, BitmapFont pointsFont,Bot bot) {
        float drawX = (texture.getWidth()-Y_ALIGNMENT_SHADOW)-18+145;
        float drawY = Gdx.graphics.getHeight()-10-(yOffset+BotState.globalOffset) *((texture.getHeight()-Y_ALIGNMENT_SHADOW)+20)-texture.getHeight()-40;
        batch.begin();
        batch.draw(texture,drawX,drawY);
        nameFont.draw(batch,bot.getName(),145+(texture.getWidth()-Y_ALIGNMENT_SHADOW)-18+(texture.getWidth()-Y_ALIGNMENT_SHADOW)/2-bot.getName().length()*3.8f,Gdx.graphics.getHeight()-5-(yOffset+BotState.globalOffset)*(((texture.getHeight()-Y_ALIGNMENT_SHADOW))+20)-10-40);
        pointsFont.draw(batch,bot.getFitnessFuncString(),145+(texture.getWidth()-Y_ALIGNMENT_SHADOW)-10+(texture.getWidth()-Y_ALIGNMENT_SHADOW)/2-(bot.getFitnessFuncString()).length()*3.7f,Gdx.graphics.getHeight()-5-(yOffset+BotState.globalOffset)*(((texture.getHeight()-Y_ALIGNMENT_SHADOW))+20)-108-40);
        pointsFont.draw(batch,bot.getHealthString(),145+(texture.getWidth()-Y_ALIGNMENT_SHADOW)-10+(texture.getWidth()-Y_ALIGNMENT_SHADOW)/2-(bot.getHealthString()).length()*3.7f,Gdx.graphics.getHeight()-5-(yOffset+BotState.globalOffset)*(((texture.getHeight()-Y_ALIGNMENT_SHADOW))+20)-135-40);
        batch.end();

    }

    public static void drawGraphElement(Texture graphElement, int x,int y,int width,float value) {
        batch.begin();
        batch.draw(graphElement,Graph.X+x+1,y,width,value*Graph.HEIGHT);
        batch.end();
    }

    public static void drawWorldPanelItem(Texture drawable, BitmapFont nameFont, BitmapFont stateFont, String worldName, long bestFitnessFuncOfAllTime, int populations,int order) {
        int Y_OFFSET = 570-(order*(drawable.getHeight()+6));
        int X_OFFSET = 30;
        batch.begin();
        batch.draw(drawable,X_OFFSET,Y_OFFSET);
        nameFont.draw(batch,worldName,X_OFFSET+70,Y_OFFSET+63);
        stateFont.draw(batch,"Best score: "+TextFormat.coolFormat(bestFitnessFuncOfAllTime)+"\nPopulation: "+TextFormat.coolFormat(populations+1),X_OFFSET+70,Y_OFFSET+40);
        batch.end();
    }

    public static void drawText(BitmapFont font,String string,float x,float y) {
        batch.begin();
        font.draw(batch,string,x,y);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        whiteNoise.dispose();
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
        mouseClicked = true;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        mouseClicked = false;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        mouseX = screenX;
        mouseY = screenY;
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
