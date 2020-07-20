package DFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumsIslands {
    public int numsIslands(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    //bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    public void bfs(int[][] grid, int i, int j) {
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[] {i, j});
        while(!list.isEmpty()) {
            int[] curr = list.remove();
            i = curr[0];
            j = curr[1];
            if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                list.add(new int[] {i + 1, j});
                list.add(new int[] {i, j + 1});
                list.add(new int[] {i - 1, j});
                list.add(new int[] {i, j - 1});
            }
        }
    }
}
