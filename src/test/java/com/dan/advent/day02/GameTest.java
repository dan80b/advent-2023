package com.dan.advent.day02;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    void isPossible() {
        Game game = new Game(1, List.of(
                new GameSet(Map.of("blue", 3, "red", 4)),
                new GameSet(Map.of("red", 1, "green", 2, "blue", 6)),
                new GameSet(Map.of("green", 2))
        ));
        assertTrue(game.isPossible());
    }

    @Test
    void isNotPossible() {
        Game game = new Game(3, List.of(
                new GameSet(Map.of("green", 8, "blue", 6, "red", 20)),
                new GameSet(Map.of("blue", 5, "red", 4, "green", 13)),
                new GameSet(Map.of("green", 5, "red", 1))
        ));
        assertFalse(game.isPossible());
    }

    @Test
    void power() {
        Game game = new Game(1, List.of(
                new GameSet(Map.of("blue", 3, "red", 4)),
                new GameSet(Map.of("red", 1, "green", 2, "blue", 6)),
                new GameSet(Map.of("green", 2))
        ));
        assertEquals(48, game.power());
    }

    @Test
    void minimumSet() {

        Game game = new Game(1, List.of(
                new GameSet(Map.of("blue", 3, "red", 4)),
                new GameSet(Map.of("red", 1, "green", 2, "blue", 6)),
                new GameSet(Map.of("green", 2))
        ));

        assertEquals(4, game.maxRed());
        assertEquals(2, game.maxGreen());
        assertEquals(6, game.maxBlue());
    }
}
