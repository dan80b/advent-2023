package com.dan.advent.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartNumberVerifierTest {

    @Test
    void verifyFirstLine() {
        String currentLine = "12.......*..";
        String nextLine =    "+.........34";
        PartNumberVerifier verifier = new PartNumberVerifier(0, "12");
        assertTrue(verifier.verify(currentLine, null, nextLine));
    }

    @Test
    void verifyMidLine() {
        String previousLine = "..*....60...";
        String currentLine =  "78..........";
        String nextLine =     ".......23...";
        PartNumberVerifier verifier = new PartNumberVerifier(0, "78");
        assertTrue(verifier.verify(currentLine, previousLine, nextLine));
    }

    @Test
    void verifyLastLine() {
        String previousLine = ".*.........*";
        String currentLine =  "1.1.......56";
        PartNumberVerifier verifier = new PartNumberVerifier(10, "1");
        assertTrue(verifier.verify(currentLine, previousLine, null));
    }

    @Test
    void verifyNotPartNumber() {
        String previousLine = "..78........";
        String currentLine =  "..*....60...";
        String nextLine =     "78..........";
        PartNumberVerifier verifier = new PartNumberVerifier(7, "60");
        assertFalse(verifier.verify(currentLine, previousLine, nextLine));
    }

    @Test
    void verifyNegativeNumber() {
        String previousLine = "+.........34";
        String currentLine =  ".......-12..";
        String nextLine =     "..78........";
        PartNumberVerifier verifier = new PartNumberVerifier(7, "-12");
        assertTrue(verifier.verify(currentLine, previousLine, nextLine));
    }
}
