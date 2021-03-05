package com.genetic.bots;

import com.genetic.bots.BotsHandling.Chromosome;
import com.genetic.bots.BotsHandling.Gene;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOHandler {
    private static long lastSave;
    public static final String separator = "-@-";
    // Saves chromosome to local directory in database.txt

    public static void saveChromosome(Chromosome chromosome) {
        if(System.currentTimeMillis()-lastSave > 500) {
            lastSave = System.currentTimeMillis();
            try {
                FileWriter writer = new FileWriter("database.txt", true);
                writer.write("\r\n" + chromosome.name + separator + parseChromosomeContent(chromosome));
                writer.flush();
                writer.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String parseChromosomeContent(Chromosome chromosome) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chromosome.content.length-1; i++) {
            res.append(chromosome.content[i].getValue()+",");
        }
        res.append(chromosome.content[chromosome.content.length-1].getValue());
        System.out.println(res.toString());
        return res.toString();
    }

    public static List<Chromosome> readAll() {
        List<Chromosome> list = new ArrayList<Chromosome>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("database.txt"));
            String all = "";
            String line = reader.readLine();
            while (line != null) {
                if(line != null && !line.equals(""))list.add(createChromosome(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static Chromosome createChromosome(String c) {
        System.out.println(c);
        String[] split = c.split(separator);
        String name = split[0];
        String[] chromosomeString = split[1].split(",");
        Gene[] content = new Gene[chromosomeString.length];
        for (int i = 0; i < content.length; i++) {
            content[i] = new Gene(Byte.parseByte(chromosomeString[i]));
        }
        return new Chromosome(content,name);
    }
}
