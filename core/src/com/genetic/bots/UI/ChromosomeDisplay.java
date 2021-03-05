package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Disposable;
import com.genetic.bots.BotsHandling.Gene;
import com.genetic.bots.Main;
import com.genetic.bots.Paint;
import com.genetic.bots.WorldsHandling.Cell;
import com.genetic.bots.WorldsHandling.World;

import java.util.Iterator;


public class ChromosomeDisplay implements Disposable {
    private static final int X_ALIGNMENT = 5,Y_ALIGNMENT = 640;

    private Gene[] chromosome;
    private String[] labels;
    private Texture box,flag;
    private BitmapFont font;
    public ChromosomeBot botInfo;

    // Restores used memory
    @Override
    public void dispose() {
        box.dispose();
        flag.dispose();
        font.dispose();
    }

    public ChromosomeDisplay(Gene[] chromosome) {
        this.chromosome = chromosome;
        labels = new String[chromosome.length];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = chromosome[i].getValue()+"";

        }
        FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("9522.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 16;
        parameter.color = Color.WHITE;
        font = freeTypeFontGenerator.generateFont(parameter);
        freeTypeFontGenerator.dispose();

        box = new Texture("grid.png");
        flag = new Texture("operationFlag.png");
        botInfo = new ChromosomeBot();
    }

    // Refreshes all labels (sets new text based on new chromosome)
    private void refreshLabels() {
        labels = new String[chromosome.length];
        for (int i = 0; i < labels.length; i++) {
            labels[i]=chromosome[i].getValue()+"";
        }
    }

    // Sets new chromosome for display
    public void setChromosome(Gene[] newChromosome) {
        chromosome = newChromosome;
        refreshLabels();
    }

    // Draw current chromosome content
    public void render() {

        for (int i = 0; i < chromosome.length/8; i++) { // Rows
            for (int j = 0; j < 8; j++) {
                Paint.draw(box, X_ALIGNMENT+j*Cell.CELL_SIZE+3,Y_ALIGNMENT-i*Cell.CELL_SIZE-20);
                Paint.drawText(font,labels[i*8+j],X_ALIGNMENT+j*Cell.CELL_SIZE+7,Y_ALIGNMENT-i*Cell.CELL_SIZE);
            }
        }
        botInfo.render();
    }

    // Lights current bot's gene
    public void drawFlag() {
        int of = (WorldStatePanel.operationFlag)%Main.worlds[Main.getSelectedWorldID()].bestBot.getChromosome().length;
        Paint.draw(flag, X_ALIGNMENT+(of%8)*Cell.CELL_SIZE+3,Y_ALIGNMENT-(of/8)*Cell.CELL_SIZE-20);
    }
}
