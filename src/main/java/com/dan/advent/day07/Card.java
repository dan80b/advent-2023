package com.dan.advent.day07;

public enum Card {

    A, K, Q, J, T, C9, C8, C7, C6, C5, C4, C3, C2;

    public int getRank(boolean isJoker) {
        if (this == J && isJoker) {
            return 20;
        } else {
            return ordinal();
        }
    }
}
