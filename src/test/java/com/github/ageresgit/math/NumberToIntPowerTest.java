package com.github.ageresgit.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberToIntPowerTest {
    NumberToIntPower power = new NumberToIntPower();

    @Test
    void test() {
        int n = -2147483648;
        double x = 2;
        double r = power.myPow(x, n);
    }
}