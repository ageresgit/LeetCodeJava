package com.github.ageresgit.graph;

import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions {
    private void markLooseZeroes(char[][] b, int r, int c) {
        if (r < 0 || c < 0 || r >= b.length || c >= b[0].length || b[r][c] == 'X' || b[r][c] == '1') return;
        b[r][c] = '1';
        markLooseZeroes(b, r + 1, c);
        markLooseZeroes(b, r - 1, c);
        markLooseZeroes(b, r, c + 1);
        markLooseZeroes(b, r, c - 1);
    }
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        if (m <= 2 || n <= 2) return;
        for (int r = 0; r < m; r++) {
            markLooseZeroes(board, r, 0);
            markLooseZeroes(board, r, n - 1);
        }
        for (int c = 0; c < n; c++) {
            markLooseZeroes(board, 0, c);
            markLooseZeroes(board, m - 1, c);
        }

        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                if (board[r][c] == 'O') board[r][c] = 'X';
                else if (board[r][c] == '1') board[r][c] = 'O';
    }
}
