package com.dan.advent.day08;

public enum Direction {

    RIGHT {
        @Override
        Vertex getNext(Vertex vertex) {
            return vertex.getRight();
        }
    },

    LEFT {
        @Override
        Vertex getNext(Vertex vertex) {
            return vertex.getLeft();
        }
    };

    abstract Vertex getNext(Vertex vertex);
}
