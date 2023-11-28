package com.github.ageresgit.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DetectRectanglesTest {

    @Test
    void countTest() {
        DetectRectangles detectRectangles = new DetectRectangles();
        detectRectangles.add(new int[]{5,10});
        detectRectangles.add(new int[]{10,5});
        detectRectangles.add(new int[]{10,10});
        Assertions.assertEquals(1, detectRectangles.count(new int[]{5, 5}));

        detectRectangles.add(new int[]{3,0});
        detectRectangles.add(new int[]{8,0});
        detectRectangles.add(new int[]{8,5});
        Assertions.assertEquals(1, detectRectangles.count(new int[]{3, 5}));

        detectRectangles.add(new int[]{9,0});
        detectRectangles.add(new int[]{9,8});
        detectRectangles.add(new int[]{1,8});
        Assertions.assertEquals(1, detectRectangles.count(new int[]{1, 0}));

        detectRectangles.add(new int[]{0,0});
        detectRectangles.add(new int[]{8,0});
        detectRectangles.add(new int[]{8,8});
        Assertions.assertEquals(3, detectRectangles.count(new int[]{0, 8}));
    }

}