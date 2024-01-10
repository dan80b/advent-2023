package com.dan.advent.day08;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Network {
    private final List<Direction> directions;
    private final Vertex start;
    private final List<Vertex> starts;
}
