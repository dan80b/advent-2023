package com.dan.advent.day08;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class NetworkNavigator {

    int countSteps(Network network) {
        NetworkPosition position = new NetworkPosition(network.getStart(), network.getDirections());
        while (!position.isEndPosition()) {
            position = position.nextPosition();
        }
        return position.getSteps();
    }

    @RequiredArgsConstructor
    private static class NetworkPosition {

        private final Vertex vertex;
        private final List<Direction> directions;
        private final int directionIndex;

        @Getter
        private final int steps;

        NetworkPosition(Vertex vertex, List<Direction> directions) {
            this(vertex, directions, 0, 0);
        }

        boolean isEndPosition() {
            return vertex.isEnd();
        }

        Vertex nextVertex() {
            Direction direction = directions.get(directionIndex);
            return direction.getNext(vertex);
        }

        NetworkPosition nextPosition() {
            int index = nextDirectionIndex();
            return new NetworkPosition(nextVertex(), directions, index, steps + 1);
        }

        private int nextDirectionIndex() {
            int index = directionIndex + 1;
            return index == directions.size() ? 0 : index;
        }
    }
}
