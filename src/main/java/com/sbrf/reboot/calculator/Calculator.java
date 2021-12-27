package com.sbrf.reboot.calculator;

public class Calculator {
    public int getAddition(int i, int i1) {
        return i + i1;
    }

    public int getSubtraction(int i, int i1) {
        return i - i1;
    }

    public int getMultiplication(int i, int i1) {
        return i * i1;
    }

    public int getDivision(int i, int i1) {
        return i / i1;
    }

    public int getMax(int i, int i1) {
        return Math.max(i, i1);
    }

    public int getMin(int i, int i1) {
        return Math.min(i, i1);
    }

    public int getAbs(int i) {
        return Math.abs(i);
    }
}
