package com.github.ageresgit.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestQuickSelectTest {
    KthLargestQuickSelect kl = new KthLargestQuickSelect();
    @Test
    void test01() {
        int[] nums = {3,2,1,5,6,4};
        assertEquals(5, kl.findKthLargest(nums, 2));
    }

}