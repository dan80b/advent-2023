package com.dan.advent.day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameParser {

    Game parse(String line) {

        String[] splits = line.split(":");
        int id = Integer.parseInt(splits[0].substring(5));

        String gameDetails = splits[1].substring(1);
        String[] sets = gameDetails.split("; ");

        List<GameSet> gameSets = new ArrayList<>();
        for (String set : sets) {
            String[] coloredCubes = set.split(", ");
            Map<String, Integer> cubes = new HashMap<>();
            for (String coloredCube : coloredCubes) {
                String[] cubeSplits = coloredCube.split(" ");
                int count = Integer.parseInt(cubeSplits[0]);
                String color = cubeSplits[1];
                cubes.put(color, count);
            }
            gameSets.add(new GameSet(cubes));
        }

        return new Game(id, gameSets);
    }
}
