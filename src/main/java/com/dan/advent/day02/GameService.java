package com.dan.advent.day02;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GameService {

    private final GameParser gameParser;

    int sumOfPossibleIds(List<String> lines) {
        return lines.stream()
                .map(gameParser::parse)
                .filter(Game::isPossible)
                .map(Game::getId)
                .reduce(0, Integer::sum);
    }

    int totalPower(List<String> lines) {
        return lines.stream()
                .map(gameParser::parse)
                .map(Game::power)
                .reduce(0, Integer::sum);
    }
}
