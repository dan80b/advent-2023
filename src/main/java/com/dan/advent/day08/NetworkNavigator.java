package com.dan.advent.day08;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NetworkNavigator {

    private final LcmCalculator lcmCalculator;

    long countSteps(Network network) {
        return countSteps(network.getStart(), network.getDirections(), false);
    }

    long countGhostSteps(Network network) {
        List<Long> steps = network.getStarts().stream()
                .map(v -> countSteps(v, network.getDirections(), true))
                .toList();
        return lcmCalculator.lcm(steps);
    }

    long countSteps(Vertex vertex, List<Direction> directions, boolean isGhost) {
        NetworkPosition position = new NetworkPosition(isGhost, vertex, directions);
        while (position.isNotEndPosition()) {
            position = position.nextPosition();
        }
        return position.getSteps();
    }

    @RequiredArgsConstructor
    private static class NetworkPosition {

        private final boolean isGhost;
        private final Vertex vertex;
        private final List<Direction> directions;
        private final int directionIndex;

        @Getter
        private final int steps;

        NetworkPosition(boolean isGhost, Vertex vertex, List<Direction> directions) {
            this(isGhost, vertex, directions, 0, 0);
        }

        boolean isNotEndPosition() {
            return isGhost ? !vertex.isGhostEnd() : !vertex.isEnd();
        }

        Vertex nextVertex() {
            Direction direction = directions.get(directionIndex);
            return direction.getNext(vertex);
        }

        NetworkPosition nextPosition() {
            int index = nextDirectionIndex();
            return new NetworkPosition(isGhost, nextVertex(), directions, index, steps + 1);
        }

        private int nextDirectionIndex() {
            int index = directionIndex + 1;
            return index == directions.size() ? 0 : index;
        }
    }
}
