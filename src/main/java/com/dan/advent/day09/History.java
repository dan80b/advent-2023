package com.dan.advent.day09;

import java.util.ArrayList;
import java.util.List;

public class History {

    private final Sequence initialSequence;
    private final List<Sequence> sequences;

    History(Sequence initialSequence) {
        this.initialSequence = initialSequence;
        this.sequences = generateSequences();
    }

    List<Sequence> generateSequences() {
        List<Sequence> sequences = new ArrayList<>();
        Sequence sequence = initialSequence;
        do {
            sequences.add(sequence);
            sequence = sequence.nextSequence();
        } while (!sequence.isAllZero());
        return sequences;
    }

    int nextValue() {
        Sequence lastSequence = sequences.get(sequences.size() - 1);
        int nextValue = lastSequence.lastValue();
        for (int i = sequences.size() - 2; i >= 0; i--) {
            Sequence current = sequences.get(i);
            nextValue = current.nextValue(nextValue);
        }
        return nextValue;
    }
}
