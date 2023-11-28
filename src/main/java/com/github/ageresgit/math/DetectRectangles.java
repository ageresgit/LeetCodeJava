package com.github.ageresgit.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectRectangles {
    Map<Integer, List<int[]>> mapByX;
    Map<Integer, List<int[]>> mapByY;
    public DetectRectangles() {
        mapByX = new HashMap<>();
        mapByY = new HashMap<>();
    }


    public void add(int[] point) {
        var listX = mapByX.computeIfAbsent(point[0], x -> new ArrayList<>());
        listX.add(point);

        var listY = mapByY.computeIfAbsent(point[1], y -> new ArrayList<>());
        listY.add(point);
    }

    public int count(int[] point) {
        var listX = mapByX.get(point[0]);
        var listY = mapByY.get(point[1]);
        if (listY == null || listX == null) return 0;
        int countRectangles = 0;
        for (int[] pointX : listX) {
            if (pointX[1] == point[1]) continue;
            for (int[] pointY : listY) {
                if (pointY[0] == point[0]) continue;
                var list4 = mapByX.get(pointY[0]);
                if (list4 == null) continue;
                for (int[] fourth : list4) {
                    if (fourth[1] == pointX[1]) countRectangles++;
                }
            }
        }
        return countRectangles;
    }
}
