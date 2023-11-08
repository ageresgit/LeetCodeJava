package com.github.ageresgit.heap;

public class KClosestPointsHeapify {
    public int[][] kClosest(int[][] points, int k) {
        int length = points.length;
        for (int i = (length >>> 1) - 1; i >= 0; i--) sift_down(points,i, length);
        int size = Integer.min(length, k);
        int[][] out = new int[size][];
        for (int i = 0; i < size; i++) {
            out[i] = points[0];
            swap(points, 0, length - 1);
            length--;
            sift_down(points, 0, length);
        }
        return out;
    }
    private int norm(int[] b) {return (b[0]*b[0] + b[1]*b[1]);}
    private void swap(int[][] a, int i, int j) {
        int[] temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private void sift_down(int[][] a, int index, int length){
        int child = 2*index + 1;
        while (child < length) {
            int n = norm(a[child]);
            if (child + 1 < length) {
                int n1 = norm(a[child + 1]);
                if (n1 < n) {child += 1; n = n1;}
            }
            if (norm(a[index]) < n) break;
            swap(a, index, child);
            index = child;
            child = 2*index + 1;
        }
    }
}
