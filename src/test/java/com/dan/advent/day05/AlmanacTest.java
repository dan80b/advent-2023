package com.dan.advent.day05;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlmanacTest {

    private static final Almanac ALMANAC = new Almanac(
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

    @Test
    void almanac() {

        /*
         0 - 49 ->  0 - 49     0 - 14 -> 39 - 53     0 -  6 -> 42 - 48     0 - 17 ->  0 - 17    0 - 44 ->  0 - 44    0 - 68 ->  1 - 69    0 - 55 ->  0 - 55
        50 - 97 -> 52 - 99    15 - 51 ->  0 - 36     7 - 10 -> 57 - 60    18 - 24 -> 88 - 94   45 - 63 -> 81 - 99   69 - 69 ->  0 -  0   56 - 92 -> 60 - 96
        98 - 99 -> 50 - 51    52 - 53 -> 37 - 38    11 - 52 ->  0 - 41    25 - 94 -> 18 - 87   64 - 76 -> 68 - 80   70 - 99 -> 70 - 99   93 - 96 -> 56 - 59
                              54 - 99 -> 54 - 99    53 - 60 -> 49 - 56    95 - 99 -> 95 - 99   77 - 99 -> 45 - 67                        97 - 99 -> 97 - 99
                                                    61 - 99 -> 61 - 99

        79 - 92 -> 81 - 94 -> 81 - 94           -> 81 - 94 -> 74 - 87 : 74 - 76 -> 78 - 84 -> 78 - 84           -> 82 - 88
                                                                        77 - 87 -> 45 - 55 -> 46 - 56 : 46 - 55 -> 46 - 55
                                                                                                      : 56 - 56 -> 60 - 60
        55 - 67 -> 57 - 69 -> 57 - 69 : 57 - 60 -> 53 - 56 -> 46 - 49           -> 82 - 85 -> 82 - 85           -> 86 - 89
                                      : 61 - 69 -> 61 - 69 -> 53 - 62           -> 89 - 98 -> 89 - 98 : 89 - 92 -> 93 - 96
                                                                                                        93 - 96 -> 56 - 59
                                                                                                        97 - 98 -> 97 - 98
         */

        assertEquals(82, ALMANAC.location(79));
        assertEquals(43, ALMANAC.location(14));
        assertEquals(86, ALMANAC.location(55));
        assertEquals(35, ALMANAC.location(13));

        assertEquals(35, ALMANAC.lowestLocation());
    }

    @Test
    void ranges() {

        List<Range<Long>> ranges = ALMANAC.seedsRanges();
        assertEquals(2, ranges.size());

        Range<Long> range1 = ranges.get(0);
        assertEquals(79, range1.getMinimum());
        assertEquals(92, range1.getMaximum());

        Range<Long> range2 = ranges.get(1);
        assertEquals(55, range2.getMinimum());
        assertEquals(67, range2.getMaximum());
    }

    @Test
    void lowestLocation() {
        assertEquals(46, ALMANAC.lowestLocation2());
    }
}
