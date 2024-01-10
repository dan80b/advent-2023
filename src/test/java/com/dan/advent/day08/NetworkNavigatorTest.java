package com.dan.advent.day08;

import static com.dan.advent.day08.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

public class NetworkNavigatorTest {

    private final NetworkNavigator networkNavigator = new NetworkNavigator(new LcmCalculator());

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
        Network network = new Network(directions, aaa, List.of(aaa));

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
        Network network = new Network(directions, aaa, List.of(aaa));

        assertEquals(6, networkNavigator.countSteps(network));
    }

    @Test
    void countGhostSteps() {

        Vertex v11a = new Vertex("11A");
        Vertex v11b = new Vertex("11B");
        Vertex v11z = new Vertex("11Z");
        Vertex v22a = new Vertex("22A");
        Vertex v22b = new Vertex("22B");
        Vertex v22c = new Vertex("22C");
        Vertex v22z = new Vertex("22Z");
        Vertex vxxx = new Vertex("XXX");

        v11a.setAdjacent(v11b, vxxx);
        v11b.setAdjacent(vxxx, v11z);
        v11z.setAdjacent(v11b, vxxx);
        v22a.setAdjacent(v22b, vxxx);
        v22b.setAdjacent(v22c, v22c);
        v22c.setAdjacent(v22z, v22z);
        v22z.setAdjacent(v22b, v22b);
        vxxx.setAdjacent(vxxx, vxxx);

        List<Direction> directions = List.of(LEFT, RIGHT);
        Network network = new Network(directions, v11a, List.of(v11a, v22a));

        assertEquals(6, networkNavigator.countGhostSteps(network));
    }
}
