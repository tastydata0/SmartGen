package com.genetic.bots;

public class Config {

    public static final int DEFAULT_SPEED = 4;
    public static int SPEED = DEFAULT_SPEED;

    private static final int DEFAULT_BOTS_COUNT = 64;
    public static int BOTS_COUNT = DEFAULT_BOTS_COUNT;

    private static final float DEFAULT_CHANCE_TO_MUTATE_ANOTHER_ONE_GENE = 0.8f;
    public static float CHANCE_TO_MUTATE_ANOTHER_ONE_GENE = DEFAULT_CHANCE_TO_MUTATE_ANOTHER_ONE_GENE;

    private static final float DEFAULT_DEGREE_OF_WALLS = 0.1f;
    public static float DEGREE_OF_WALLS = DEFAULT_DEGREE_OF_WALLS;

    private static final float DEFAULT_DEGREE_OF_HUMANS = 0.05f;
    public static float DEGREE_OF_HUMANS = DEFAULT_DEGREE_OF_HUMANS;

    private static final float DEFAULT_DEGREE_OF_FIRE = 0.01f;
    public static float DEGREE_OF_FIRE = DEFAULT_DEGREE_OF_FIRE;

    private static final int DEFAULT_BOTS_MEMORY_SIZE = 32;
    public static int BOTS_MEMORY_SIZE = DEFAULT_BOTS_MEMORY_SIZE;

    public static final int MAP_WIDTH = 36;
    public static final int MAP_HEIGHT = 24;

    public static boolean IS_DEVELOPER_MODE_ENABLED = true;

    private Config() {

    }
}
