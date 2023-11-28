package com.github.ageresgit.math;

import java.util.*;

public class DetectSquares {
    class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    Map<Integer, List<int[]>> mapByX;
    Map<Point, Integer> mapCounter;

    public DetectSquares() {
        mapByX = new HashMap<>();
        mapCounter = new HashMap<>();
    }

    public void add(int[] point) {
        var listX = mapByX.computeIfAbsent(point[0], x -> new ArrayList<>());
        listX.add(point);
        Point addPoint = new Point(point[0], point[1]);
        Integer pointCounter = mapCounter.getOrDefault(addPoint, 0) + 1;
        mapCounter.put(addPoint, pointCounter);
    }

    public int count(int[] point) {
        int counter = 0;
        for (int[] pointX : mapByX.computeIfAbsent(point[0], x -> new ArrayList<>())) {
            if (pointX[1] == point[1]) continue;
            int size = Math.abs(pointX[1] - point[1]);
            counter += mapCounter.getOrDefault(new Point(point[0] + size, point[1]), 0) *
                    mapCounter.getOrDefault(new Point(point[0] + size, pointX[1]), 0);
            counter += mapCounter.getOrDefault(new Point(point[0] - size, point[1]), 0) *
                    mapCounter.getOrDefault(new Point(point[0] - size, pointX[1]), 0);
        }

        return counter;
    }
}
