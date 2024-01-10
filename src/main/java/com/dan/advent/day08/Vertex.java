package com.dan.advent.day08;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Vertex {

    private static final String START_VERTEX = "AAA";
    private static final String END_VERTEX = "ZZZ";

    private final String name;

    private Vertex left;
    private Vertex right;

    void setAdjacent(Vertex left, Vertex right) {
        this.left = left;
        this.right = right;
    }

    boolean isStart() {
        return START_VERTEX.equals(name);
    }

    boolean isEnd() {
        return END_VERTEX.equals(name);
    }

    boolean isGhostStart() {
        return name.endsWith("A");
    }

    boolean isGhostEnd() {
        return name.endsWith("Z");
    }

    @Override
    public String toString() {
        return name;
    }
}
