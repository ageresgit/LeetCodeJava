package com.github.ageresgit.math.arithmetics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyStringsTest {
    MultiplyStrings multiplyStrings = new MultiplyStrings();
    @Test
    void testMultiply111By100() {
        Assertions.assertEquals("11100", multiplyStrings.multiply("111", "100"));
        Assertions.assertEquals("11100", multiplyStrings.multiply("100", "111"));
    }
    @Test
    void testMultiply111By200() {
        Assertions.assertEquals("22200", multiplyStrings.multiply("222", "100"));
        Assertions.assertEquals("22200", multiplyStrings.multiply("200", "111"));
    }

    @Test
    void testMultiply999By888() {
        Assertions.assertEquals("887112", multiplyStrings.multiply("999", "888"));
        Assertions.assertEquals("887112", multiplyStrings.multiply("888", "999"));
    }

    @Test
    void nullSort() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(null);
        integerList.add(1);
        integerList.add(2);
        integerList.add(null);
        List<Integer> out = multiplyStrings.nullSort(integerList);
        Integer[] outArray = {null, null, 1, 2, 5};
        Assertions.assertArrayEquals(outArray, out.toArray());
    }
}