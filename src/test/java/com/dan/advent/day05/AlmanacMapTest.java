package com.dan.advent.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

public class AlmanacMapTest {

    private static final AlmanacMap ALMANAC_MAP = new AlmanacMap(List.of(
            new AlmanacLine(50, 98, 2),
            new AlmanacLine(52, 50, 48)
    ));

    @Test
    void destination() {
        assertEquals(81, ALMANAC_MAP.destination(79));
        assertEquals(14, ALMANAC_MAP.destination(14));
        assertEquals(57, ALMANAC_MAP.destination(55));
        assertEquals(13, ALMANAC_MAP.destination(13));
    }
}
