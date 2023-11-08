package com.github.ageresgit.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianFinderTest {
    @Test
    void test001() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        assertEquals(1.5, mf.findMedian());
    }
}