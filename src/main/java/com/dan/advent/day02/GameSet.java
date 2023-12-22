package com.dan.advent.day02;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Map;

@RequiredArgsConstructor
@Getter
@ToString
public class GameSet {
    private final Map<String, Integer> cubes;
}
