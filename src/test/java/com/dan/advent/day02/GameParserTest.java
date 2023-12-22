package com.dan.advent.day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameParserTest {

    private final GameParser gameParser = new GameParser();

    @Test
    void load() {
        String line = "Game 1: 2 blue, 3 red; 3 green, 3 blue, 6 red; 4 blue, 6 red; 2 green, 2 blue, 9 red; 2 red, 4 blue";
        Game game = gameParser.parse(line);
        assertEquals(1, game.getId());
        assertEquals(5, game.getSets().size());
        assertEquals(3, game.getSets().get(1).getCubes().size());
        assertEquals(6, game.getSets().get(1).getCubes().get("red"));
    }
}
