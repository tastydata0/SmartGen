package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.genetic.bots.BotsHandling.Bot;
import com.genetic.bots.Paint;
import com.genetic.bots.WorldsHandling.World;

// Uses with ChromosomeDisplay.class, bestbot frame
public class ChromosomeBot extends BotInfo {
    private Texture crown;

    //TODO dispose
    public ChromosomeBot(Bot bot, float yOffset) {
        super(bot, yOffset);

    }

    public ChromosomeBot() {
        yOffset = 0.28f;
        bot = null;
        crown = new Texture("crown.png");
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

    // Sets new bot (always this bot is best)
    public void setBot(Bot bot) {
        this.bot = bot;
    }

    // Draw bot-info frame
    @Override
    protected void render() {
        if(bot!=null){
            Paint.drawBotInfoForChromosome(botInfo,yOffset,nameFont,pointsFont,bot);
            Paint.draw(crown,227,626);
        }

    }
}
