package com.github.ageresgit.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    final int FRESH = 1;
    final int ROTTEN = 2;
    private boolean isFresh(int[][] g, int r, int c) {
        return (r >= 0 && c >= 0 && r < g.length && c < g[0].length && g[r][c] == FRESH);
    }
    public int orangesRotting(int[][] grid) {
        Queue<Integer> xs = new LinkedList<>();
        Queue<Integer> ys = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int good = 0;
        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == FRESH) good++;
                else if (grid[row][col] == ROTTEN) {
                    xs.offer(row);
                    ys.offer(col);
                }
            }
        int time = 0;
        while (good > 0 && !xs.isEmpty()) {
            time++;
            for (int step = xs.size(); step > 0; step--) {
                int row = xs.poll(), col = ys.poll();
                for (int[] a : directions) {
                    int r = row + a[0], c = col + a[1];
                    if (isFresh(grid, r, c)) {xs.offer(r); ys.offer(c); grid[r][c] = ROTTEN; good--;}
                }
            }
        }
        return (good > 0)? (-1) : time;
    }
}
