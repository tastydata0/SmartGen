package com.genetic.bots;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.genetic.bots.WorldsHandling.Cell;

public class MapReader {
    public MapReader() {

    }

    // Read map from *.txt file
    public Cell[][] read(String fileName){
        Cell[][] cells = null;
        try {
            FileHandle handle = Gdx.files.internal("maps/"+fileName.replaceAll(".txt","")+".txt");
            String map = handle.readString();
            String[] strings = map.split("\n");
            cells = new Cell[Config.MAP_WIDTH][Config.MAP_HEIGHT];
            for (int y = 0; y < Config.MAP_HEIGHT; y++) {
                String[] ids = strings[y].split(",");
                for (int x = 0; x < Config.MAP_WIDTH; x++) {
                    cells[x][y] = new Cell(Byte.parseByte(strings[y].charAt(x*2)+""),x,y);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return cells;
    }


}
