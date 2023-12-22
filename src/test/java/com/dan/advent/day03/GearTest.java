package com.dan.advent.day03;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GearTest {

    @Test
    void value() {
        Gear gear = new Gear(1, 2);
        gear.setLeft(3);
        gear.setRight(4);
        assertEquals(12, gear.value());
    }

    @Test
    void getItselfFromSetFound() {
        Gear gear = new Gear(1, 2);
        Optional<Gear> foundGear = gear.getItselfFromSet(Set.of(new Gear(1, 2)));
        assertTrue(foundGear.isPresent());
    }

    @Test
    void getItselfFromSetNotFound() {
        Gear gear = new Gear(1, 2);
        Optional<Gear> foundGear = gear.getItselfFromSet(Set.of(new Gear(3, 2)));
        assertTrue(foundGear.isEmpty());
    }
}
