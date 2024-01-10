package com.dan.advent.day08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkParser {

    Network parse(List<String> lines) {

        List<Direction> directions = null;
        List<Vertex> vertexList = new ArrayList<>();
        List<Vertex> left = new ArrayList<>();
        List<Vertex> right = new ArrayList<>();
        Map<String, Vertex> vertexMap = new HashMap<>();

        for (String line : lines) {
            if (isDirections(line)) {
                directions = parseDirections(line);
            } else if (isVertex(line)) {
                vertexList.add(getVertex(vertexMap, line.substring(0, 3)));
                left.add(getVertex(vertexMap, line.substring(7, 10)));
                right.add(getVertex(vertexMap, line.substring(12, 15)));
            }
        }

        for (int i = 0; i < vertexList.size(); i++) {
            vertexList.get(i).setAdjacent(left.get(i), right.get(i));
        }

        Vertex startVertex = getStartVertex(vertexList);
        List<Vertex> startVertexList = getStartVertexList(vertexList);
        return new Network(directions, startVertex, startVertexList);
    }

    private Vertex getVertex(Map<String, Vertex> vertexMap, String name) {
        if (!vertexMap.containsKey(name)) {
            vertexMap.put(name, new Vertex(name));
        }
        return vertexMap.get(name);
    }

    private boolean isDirections(String line) {
        return line.matches("^[LR]+");
    }

    private List<Direction> parseDirections(String line) {
        return line.chars()
                .boxed()
                .map(c -> map((char) (int) c))
                .toList();

    }

    private Direction map(char c) {
        return switch (c) {
            case 'R' -> Direction.RIGHT;
            case 'L' -> Direction.LEFT;
            default -> throw new IllegalArgumentException("Invalid direction: " + c);
        };
    }

    private boolean isVertex(String line) {
        return !line.isBlank() && Character.isLetter(line.charAt(0));
    }

    private Vertex getStartVertex(List<Vertex> vertexList) {
        return vertexList.stream()
                .filter(Vertex::isStart)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No starting vertex found"));
    }

    private List<Vertex> getStartVertexList(List<Vertex> vertexList) {
        return vertexList.stream()
                .filter(Vertex::isGhostStart)
                .toList();
    }
}
