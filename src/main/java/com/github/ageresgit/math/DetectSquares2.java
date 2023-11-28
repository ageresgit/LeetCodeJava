package com.github.ageresgit.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares2 {
    List<int[]> points;
    Map<String, Integer> pointCounts;

    String getKeyString(int x, int y) {return x + "," + y;}

    DetectSquares2() {
        points = new ArrayList<>();
        pointCounts = new HashMap<>();
    }

    public void add(int[] point) {
        points.add(point);
        String key = getKeyString(point[0], point[1]);
        pointCounts.put(key, pointCounts.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int counter = 0;
        for (int[] diagonal : points) {
            if (diagonal[0] == point[0] || Math.abs(diagonal[0] - point[0]) != Math.abs(diagonal[1] - point[1])) continue;
            int a = pointCounts.getOrDefault(getKeyString(diagonal[0], point[1]), 0);
            if (a == 0) continue;
            counter += (a * pointCounts.getOrDefault(getKeyString(point[0], diagonal[1]), 0));
        }
        return counter;
    }
}
