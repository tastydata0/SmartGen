package com.genetic.bots.BotsHandling;

public class Chromosome {
    public Gene[] content;
    public String name;
    public int length;

    public Chromosome(Gene[] content, String name) {
        this.content = content;
        this.name = name;
        length = content.length;
    }
}
