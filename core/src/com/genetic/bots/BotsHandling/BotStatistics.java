package com.genetic.bots.BotsHandling;

public class BotStatistics {
    int id,savedPeople,extinguishedFire;
    String chromosome,name;

    private boolean hasConcreteID = true;

    public BotStatistics(int id, int savedPeople, int extinguishedFire, String chromosome, String name) {
        this.id = id;
        this.savedPeople = savedPeople;
        this.extinguishedFire = extinguishedFire;
        this.chromosome = chromosome;
        this.name = name;

        if(id == -1) {
            hasConcreteID = false;
        }
    }

    public boolean hasConcreteID() {
        return hasConcreteID;
    }
}
