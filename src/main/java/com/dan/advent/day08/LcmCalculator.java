package com.dan.advent.day08;

import java.util.List;

public class LcmCalculator {

    long lcm(List<Long> numbers) {
        return numbers.stream()
                .reduce(1L, (x, y) -> (x * y) / gcd(x, y));
    }

    long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
