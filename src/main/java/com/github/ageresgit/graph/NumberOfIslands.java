package com.github.ageresgit.graph;

public class NumberOfIslands {
    void bfs(char[][] graph, boolean[][] visited, int r, int c) {
        if (r >= 0 && r < graph.length && c >= 0 && c < graph[0].length && !visited[r][c] && graph[r][c] == '1') {
            visited[r][c] = true;
            bfs(graph, visited, r - 1, c);
            bfs(graph, visited, r + 1, c);
            bfs(graph, visited, r, c - 1);
            bfs(graph, visited, r, c + 1);
        }
    }
    public int numIslands(char[][] grid) {
        boolean[][] visited =new boolean[grid.length][grid[0].length];
        int islands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    islands++;
                    bfs(grid, visited, r, c);
                }
            }
        }
        return islands;
    }
}
