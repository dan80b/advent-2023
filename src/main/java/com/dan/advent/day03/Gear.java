package com.dan.advent.day03;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter
public class Gear {

    private final int x;
    private final int y;

    private int left;
    private int right;

    int value() {
        return left * right;
    }

    Optional<Gear> getItselfFromSet(Set<Gear> gears) {
        return gears.stream()
                .filter(gear -> gear.equals(this))
                .findFirst();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gear gear = (Gear) o;
        return x == gear.x && y == gear.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
