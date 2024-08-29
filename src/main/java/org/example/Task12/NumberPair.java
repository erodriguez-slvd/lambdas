package org.example.Task12;

public class NumberPair {
    private int value1;
    private int value2;

    public NumberPair(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    @Override
    public String toString() {
        return "NumberPair{" + "(" + value1 + ", " + value2 + ')';
    }
}
