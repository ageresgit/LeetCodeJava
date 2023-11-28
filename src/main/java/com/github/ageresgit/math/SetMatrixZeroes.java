package com.github.ageresgit.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;
        int colCount = matrix[0].length;
        int rowCount = matrix.length;
        // Check if first column or first row should be zeroed
        if (matrix[0][0] == 0) {firstColZero = true; firstRowZero = true;}
        else {
            for (int value : matrix[0]) {
                if (value == 0) {
                    firstRowZero = true;
                    break;
                }
            }
            for (int[] row : matrix) {
                if (row[0] == 0) {
                    firstColZero = true;
                    break;
                }
            }
        }
        // Look for matrix zeroes and put them into the first row and into the first column
        for (int row = 1; row < rowCount; row++)
            for (int col = 1; col < colCount; col++)
                if (matrix[row][col] == 0) {matrix[0][col] = 0; matrix[row][0] = 0;}
        // Zeroing rows
        for (int row = 1; row < rowCount; row++) {
            if (matrix[row][0] == 0) for (int col = 1; col < colCount; col++) matrix[row][col] = 0;
        }
        // Zeroing columns
        for (int col = 1; col < colCount; col++) {
            if (matrix[0][col] == 0) for (int row = 1; row < rowCount; row++) matrix[row][col] = 0;
        }
        // Zeroing first row and/or first column if needed
        if (firstRowZero) for (int col = 0; col < colCount; col++) matrix[0][col] = 0;
        if (firstColZero) for (int row = 0; row < rowCount; row++) matrix[row][0] = 0;
    }
}
