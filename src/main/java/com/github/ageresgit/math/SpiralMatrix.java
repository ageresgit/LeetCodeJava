package com.github.ageresgit.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return Collections.emptyList();
        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;
        List<Integer> spiral = new ArrayList<>();

        while (top < bottom && left < right) {
            for (int col = left; col < right; col++) spiral.add(matrix[top][col]);
            ++top;
            for (int row = top; row < bottom; row++) spiral.add(matrix[row][right - 1]);
            --right;
            if (!(top < bottom && left < right)) break;
            for (int col = right - 1; col >= left; col--) spiral.add(matrix[bottom - 1][col]);
            --bottom;
            for (int row = bottom - 1; row >= top; row--) spiral.add(matrix[row][left]);
            ++left;
        }
        return spiral;
    }
}
