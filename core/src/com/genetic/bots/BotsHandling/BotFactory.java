package com.genetic.bots.BotsHandling;

import java.util.Random;

public class BotFactory {
    private static Random random = new Random();
    public static int POINTS_PER_SAVED_PEOPLE = 10;
    public static int POINTS_PER_EXTINGUISHED_FIRE = 4;

    public BotFactory() {

    }

    // Creates new bot with random genes
    public Bot createNewBot(int memorySize) {
        Gene[] genes = new Gene[memorySize];

        // Generating random genes
        for (int i = 0; i < genes.length; i++) {
            genes[i] = new Gene((byte) random.nextInt(64));
        }

        return new Bot(new Chromosome(genes,"Default"));
    }

     public Gene[] parseChromosome(String c) {
        Gene[] res;
        String[] genes = c.split(",");
        res = new Gene[genes.length];
        for (int i = 0; i < genes.length; i++) {
            res[i] = new Gene(Byte.parseByte(genes[i]));
        }
        return res;
    }

    // Changes [1 to ?] bot's genes to random values
    public Bot mutate(Bot bot,float chanceToMutateAnotherOneGene) {
        do {
            bot.mutateOneGene();
        } while (chanceToMutateAnotherOneGene > Math.random());

        return bot;
    }

    // Creation new bot with cloned chromosome of @param bot
    public Bot generateByBotsChromosome(Bot bot) {
        return new Bot(new Chromosome(bot.getChromosome().content.clone(),"Default"));
    }

    public Bot generateByChromosome(Chromosome chromosome) {
        return new Bot(chromosome);
    }

}
