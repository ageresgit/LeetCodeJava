package com.github.ageresgit.graph;

public class MaxAreaOfIland {
    boolean isAPartOfAnIsland(int[][] graph, boolean[][] visited, int r, int c) {
        if (r >= 0 && c >= 0 && r < graph.length && c < graph[0].length && !visited[r][c] && graph[r][c] == 1) return true;
        return false;
    }
    int bfs(int[][] graph, boolean[][] visited, int r, int c, int area) {
        visited[r][c] = true;
        area += 1;
        area = isAPartOfAnIsland(graph, visited, r - 1, c)?bfs(graph, visited, r - 1, c, area):area;
        area = isAPartOfAnIsland(graph, visited, r + 1, c)?bfs(graph, visited, r + 1, c, area):area;
        area = isAPartOfAnIsland(graph, visited, r, c - 1)?bfs(graph, visited, r, c - 1, area):area;
        area = isAPartOfAnIsland(graph, visited, r, c + 1)?bfs(graph, visited, r, c + 1, area):area;

        return area;
    }
    public int getArea(int[][] grid, boolean[][] visited, int r, int c) {
        return bfs(grid, visited, r, c, 0);
    }
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for(int r = 0; r < grid.length; r++)
            for(int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && visited[r][c] == false) {
                    maxArea = Integer.max(maxArea, getArea(grid, visited, r, c));
                }
            }
        return maxArea;
    }
}
