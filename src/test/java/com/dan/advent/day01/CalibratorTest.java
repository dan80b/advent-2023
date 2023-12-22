package com.dan.advent.day01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalibratorTest {

    private final Calibrator calibrator = new Calibrator();

    @Test
    void calibrate() {

        assertEquals(12, calibrator.calibrate("1abc2"));
        assertEquals(38, calibrator.calibrate("pqr3stu8vwx"));
        assertEquals(15, calibrator.calibrate("a1b2c3d4e5f"));
        assertEquals(77, calibrator.calibrate("treb7uchet"));

        assertEquals(29, calibrator.calibrate("two1nine"));
        assertEquals(83, calibrator.calibrate("eightwothree"));
        assertEquals(13, calibrator.calibrate("abcone2threexyz"));
        assertEquals(24, calibrator.calibrate("xtwone3four"));
        assertEquals(42, calibrator.calibrate("4nineeightseven2"));
        assertEquals(14, calibrator.calibrate("zoneight234"));
        assertEquals(76, calibrator.calibrate("7pqrstsixteen"));

        assertEquals(72, calibrator.calibrate("seveneight7dsvqnjsjsqlkeightwovzt"));
        assertEquals(26, calibrator.calibrate("two4eightfgrsix1five7six"));
    }

    @Test
    void calibrateTotal() {

        List<String> lines = List.of("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet");
        assertEquals(142, calibrator.calibrate(lines));

        List<String> lines2 = List.of("two1nine", "eightwothree", "abcone2threexyz", "xtwone3four", "4nineeightseven2", "zoneight234", "7pqrstsixteen");
        assertEquals(281, calibrator.calibrate(lines2));
    }
}
