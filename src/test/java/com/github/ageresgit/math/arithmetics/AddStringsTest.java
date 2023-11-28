package com.github.ageresgit.math.arithmetics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AddStringsTest {
    AddStrings adder = new AddStrings();

    @Test
    void test() {
        Assertions.assertEquals("134", adder.addStrings("11", "123"));
        Assertions.assertEquals("0", adder.addStrings("0", "0"));
    }
    public List<Integer> nullSort(List<Integer> source) {
        return source.stream().sorted((o1, o2) -> {
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o1.compareTo(o2);
        }).collect(Collectors.toList());
    }
}