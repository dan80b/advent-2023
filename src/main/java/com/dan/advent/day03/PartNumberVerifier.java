package com.dan.advent.day03;

import lombok.Getter;

public class PartNumberVerifier {

    private final int startIndex;
    private final int endIndex;

    @Getter
    private final String number;

    PartNumberVerifier(int startIndex, String number) {

        if (number.startsWith("-")) {
            number = number.substring(1);
            startIndex = startIndex + 1;
        }

        this.startIndex = startIndex;
        this.endIndex = startIndex + number.length() - 1;
        this.number = number;
    }

    boolean verify(String currentLine, String previousLine, String nextLine) {
        return hasAdjacentSymbolInCurrentLine(currentLine) ||
                (previousLine != null && hasAdjacentSymbolInAdjacentLine(previousLine)) ||
                (nextLine != null && hasAdjacentSymbolInAdjacentLine(nextLine));
    }

    private boolean hasAdjacentSymbolInCurrentLine(String currentLine) {
        if (startIndex > 0 && isSpecialCharacter(currentLine.charAt(startIndex - 1))) {
            return true;
        }
        return endIndex < currentLine.length() - 1 && isSpecialCharacter(currentLine.charAt(endIndex + 1));
    }

    private boolean hasAdjacentSymbolInAdjacentLine(String line) {
        for (int i = startIndex - 1; i <= endIndex + 1; i++) {
            if (i >= 0 && i < line.length() && isSpecialCharacter(line.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isSpecialCharacter(char c) {
        return !Character.isDigit(c) && c != '.';
    }
}
