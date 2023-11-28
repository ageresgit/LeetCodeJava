package com.github.ageresgit.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {
    HappyNumber happyNumber = new HappyNumber();
    @Test
    void test0() {
        for (int i = 1; i < 20; i++) {
            System.out.println(happyNumber.happyNumber(i, 20));
        }
    }
}