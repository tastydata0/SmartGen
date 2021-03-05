package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.genetic.bots.BotsHandling.Bot;
import com.genetic.bots.Paint;

public class BotInfo extends Actor implements Comparable<BotInfo> {
    protected Bot bot;

    float yOffset;

    protected static Texture botInfo = new Texture(Gdx.files.internal("botInfo.png"));
    protected static BitmapFont nameFont, pointsFont;

    // Restores used memory
    public static void dispose() {
        nameFont.dispose();
        pointsFont.dispose();
        botInfo.dispose();
    }

    // Font initialization
    static {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color = Color.WHITE;
        parameter.size = 14;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("9522.ttf"));
        nameFont = generator.generateFont(parameter);
        parameter.size = 14;

        pointsFont = generator.generateFont(parameter);
        generator.dispose();
    }

    // Compares bot's fitness functions
    @Override
    public int compareTo(BotInfo o) {
        return bot.compareTo(o.bot);
    }

    public BotInfo(Bot bot, float yOffset) {
        this.bot = bot;
        this.yOffset = yOffset;
        bot.linkTo(this);

    }

    public BotInfo(){

    }

    // Returns linked bot
    public Bot getBot() {
        return bot;
    }

    // Draw bot-info frame
    protected void render() {
        Paint.drawBotInfo(botInfo,null,yOffset,nameFont,pointsFont,bot);
    }
}
