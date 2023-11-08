package com.github.ageresgit.heap;

import java.util.PriorityQueue;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<IntPoint> queue = new PriorityQueue<>();
        for (int[] a : points) {
            if (queue.size() < k) queue.offer(new IntPoint(a[0],a[1]));
            else {
                int d = IntPoint.norm(a[0], a[1]);
                if (d < queue.peek().getNorm()) {
                    queue.poll();
                    queue.offer(new IntPoint(a[0], a[1], d));
                }
            }
        }
        int[][] arr = new int[queue.size()][2];
        while (!queue.isEmpty()) {
            IntPoint p = queue.poll();
            arr[queue.size()][0] = p.x;
            arr[queue.size()][1] = p.y;
        }
        return arr;
    }
    private static class IntPoint implements Comparable{
        static public int norm(int x, int y){return x*x + y*y;}
        int x;
        int y;
        private int norm;
        IntPoint(int x, int y) {
            this.x = x;
            this.y = y;
            this.norm = norm(x, y);
        }
        public IntPoint(int x, int y, int norm) {
            this.x = x;
            this.y = y;
            this.norm = norm;
        }
        public int getNorm() {
            return norm;
        }
        @Override
        public int compareTo(Object o) {
            if (o == null) return -1;
            return ((IntPoint) o).norm - norm;
        }
    }
}
