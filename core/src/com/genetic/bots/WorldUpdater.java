package com.genetic.bots;

import com.genetic.bots.WorldsHandling.World;

public class WorldUpdater extends Thread {
    private World world;
    //public boolean active = true;

    public WorldUpdater(World world) {
        this.world = world;
    }

    public synchronized void setWorld(World world) {
        this.world = world;
    }

    // Main loop for each world; Speed based on Config.SPEED value
    @Override
    public void run() {
        super.run();
        setPriority(10);
        try {
            while (true) {
                world.update();
                Thread.sleep(1024/Config.SPEED);
            }
        } catch (NullPointerException e) {
            //e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void testWait() {
        final long INTERVAL = 65536;
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while(start + INTERVAL >= end);
    }
}
