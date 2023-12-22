package com.dan.advent.day01;

import com.dan.advent.common.DocumentReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DocumentReader documentReader = new DocumentReader();
        Calibrator calibrator = new Calibrator();

        try {
            List<String> lines = documentReader.readLines("input_day01.txt");
            int result = calibrator.calibrate(lines); //53312
            System.out.println("Total calibration value is: " + result);
        } catch (Exception e) {
            System.out.println("Error when calibrating: " + e.getMessage());
        }
    }
}
