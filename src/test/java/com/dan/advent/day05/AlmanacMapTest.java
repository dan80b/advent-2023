package com.dan.advent.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

public class AlmanacMapTest {

    @Test
    void destination() {

        AlmanacMap almanacMap = new AlmanacMap(List.of(
                new AlmanacLine(50, 98, 2),
                new AlmanacLine(52, 50, 48)
        ));

        assertEquals(81, almanacMap.destination(79));
        assertEquals(14, almanacMap.destination(14));
        assertEquals(57, almanacMap.destination(55));
        assertEquals(13, almanacMap.destination(13));
    }
}
