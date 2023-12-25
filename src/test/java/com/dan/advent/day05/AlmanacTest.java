package com.dan.advent.day05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlmanacTest {

    @Test
    void almanac() {

        Almanac almanac = new Almanac(
                List.of(79L, 14L, 55L, 13L),
                List.of(
                        new AlmanacMap(List.of(
                                new AlmanacLine(50, 98, 2),
                                new AlmanacLine(52, 50, 48)
                        )),
                        new AlmanacMap(List.of(
                                new AlmanacLine(0, 15, 37),
                                new AlmanacLine(37, 52, 2),
                                new AlmanacLine(39, 0, 15)
                        )),
                        new AlmanacMap(List.of(
                                new AlmanacLine(49, 53, 8),
                                new AlmanacLine(0, 11, 42),
                                new AlmanacLine(42, 0, 7),
                                new AlmanacLine(57, 7, 4)
                        )),
                        new AlmanacMap(List.of(
                                new AlmanacLine(88, 18, 7),
                                new AlmanacLine(18, 25, 70)
                        )),
                        new AlmanacMap(List.of(
                                new AlmanacLine(45, 77, 23),
                                new AlmanacLine(81, 45, 19),
                                new AlmanacLine(68, 64, 13)
                        )),
                        new AlmanacMap(List.of(
                                new AlmanacLine(0, 69, 1),
                                new AlmanacLine(1, 0, 69)
                        )),
                        new AlmanacMap(List.of(
                                new AlmanacLine(60, 56, 37),
                                new AlmanacLine(56, 93, 4)
                        ))
                )
        );

        assertEquals(82, almanac.location(79));
        assertEquals(43, almanac.location(14));
        assertEquals(86, almanac.location(55));
        assertEquals(35, almanac.location(13));

        assertEquals(35, almanac.lowestLocation());
    }
}
