package com.dan.advent.day08;

import static com.dan.advent.day08.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

public class NetworkNavigatorTest {

    private final NetworkNavigator networkNavigator = new NetworkNavigator();

    @Test
    void countSteps1() {

        Vertex aaa = new Vertex("AAA");
        Vertex bbb = new Vertex("BBB");
        Vertex ccc = new Vertex("CCC");
        Vertex ddd = new Vertex("DDD");
        Vertex eee = new Vertex("EEE");
        Vertex ggg = new Vertex("GGG");
        Vertex zzz = new Vertex("ZZZ");

        aaa.setAdjacent(bbb, ccc);
        bbb.setAdjacent(ddd, eee);
        ccc.setAdjacent(zzz, ggg);
        ddd.setAdjacent(ddd, ddd);
        eee.setAdjacent(eee, eee);
        ggg.setAdjacent(ggg, ggg);
        zzz.setAdjacent(zzz, zzz);

        List<Direction> directions = List.of(RIGHT, LEFT);
        Network network = new Network(directions, aaa);

        assertEquals(2, networkNavigator.countSteps(network));
    }

    @Test
    void countSteps2() {

        Vertex aaa = new Vertex("AAA");
        Vertex bbb = new Vertex("BBB");
        Vertex zzz = new Vertex("ZZZ");

        aaa.setAdjacent(bbb, bbb);
        bbb.setAdjacent(aaa, zzz);
        zzz.setAdjacent(zzz, zzz);

        List<Direction> directions = List.of(LEFT, LEFT, RIGHT);
        Network network = new Network(directions, aaa);

        assertEquals(6, networkNavigator.countSteps(network));
    }
}
