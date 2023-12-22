package com.dan.advent.day02;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
@ToString
public class Game {

    private static final int RED_CUBES = 12;
    private static final int GREEN_CUBES = 13;
    private static final int BLUE_CUBES = 14;

    private final int id;
    private final List<GameSet> sets;

    boolean isPossible() {
        return RED_CUBES >= maxRed() &&
                GREEN_CUBES >= maxGreen() &&
                BLUE_CUBES >= maxBlue();
    }

    int power() {
        return maxRed() * maxGreen() * maxBlue();
    }

    int maxRed(){
        return maxOfColor("red");
    }

    int maxGreen(){
        return maxOfColor("green");
    }

    int maxBlue(){
        return maxOfColor("blue");
    }

    private int maxOfColor(String color){
        return sets.stream()
                .map(set -> set.getCubes().get(color))
                .filter(Objects::nonNull)
                .reduce(0, Integer::max);
    }
}
