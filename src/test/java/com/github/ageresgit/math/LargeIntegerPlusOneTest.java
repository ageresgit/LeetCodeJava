package com.github.ageresgit.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargeIntegerPlusOneTest {
    LargeIntegerPlusOne plusOne = new LargeIntegerPlusOne();
    @Test
    void test0() {
        int[] input = {8, 9, 9, 9};
        int[] answer = {9, 0, 0, 0};
        Assertions.assertArrayEquals(answer, plusOne.plusOne(input));
    }
}