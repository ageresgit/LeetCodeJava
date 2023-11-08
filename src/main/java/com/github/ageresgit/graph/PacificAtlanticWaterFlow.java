package com.github.ageresgit.graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    boolean isReachable(int r, int c, int val, int[][] h, boolean[][] ocean) {
        if (r >= 0 && c >= 0 && r < h.length && c < h[0].length && h[r][c] >= val && !ocean[r][c])
            return true;
        return false;
    }
    void dfs(int r, int c, int[][] h, boolean[][] ocean) {
        ocean[r][c] = true;
        if (isReachable(r + 1, c, h[r][c], h, ocean)) dfs(r + 1, c, h, ocean);
        if (isReachable(r - 1, c, h[r][c], h, ocean)) dfs(r - 1, c, h, ocean);
        if (isReachable(r, c + 1, h[r][c], h, ocean)) dfs(r, c + 1, h, ocean);
        if (isReachable(r, c - 1, h[r][c], h, ocean)) dfs(r, c - 1, h, ocean);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<List<Integer>> list = new ArrayList<>();
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            if (!atlantic[m - 1][i]) dfs(m - 1, i, heights, atlantic);
            if (!pacific[0][i]) dfs(0, i, heights, pacific);
        }
        for (int j = 0; j < m; j++) {
            if (!atlantic[j][n - 1]) dfs(j, n - 1, heights, atlantic);
            if (!pacific[j][0]) dfs(j, 0, heights, pacific);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (atlantic[i][j] &&  pacific[i][j]) list.add(List.of(i, j));
        return list;
    }
}
