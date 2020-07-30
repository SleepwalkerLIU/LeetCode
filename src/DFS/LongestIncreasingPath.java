package DFS;

public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
            return 0;
        }
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j, res, visited));
            }
        }
        return max;
    }

    /**
     * @param matrix 给定的整数矩阵
     * @param x 当前起点 X
     * @param y 当前起点 Y
     * @param res 记忆化数组
     * @param visited 标记单元格是否被访问
     */
    public int dfs(int[][] matrix, int x, int y, int[][] res, boolean[][] visited) {
        if (res[x][y] != 0) {
            return res[x][y];
        }
        // 标记单元格是否被访问过
        visited[x][y] = true;
        // 矩阵宽高
        int m = matrix.length;
        int n = matrix[0].length;
        // 上下左右四个方向
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        // 路径长度
        int len = 0;
        // 遍历四个方向
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 0 <= nx < m 表示nx在矩阵范围内
            // 0 <= ny < n 表示ny在矩阵范围内
            // matrix[x][y] < matrix[nx][ny] 表示邻居单元格值比当前大
            // !visited[nx][ny] 表示没有被标记访问过
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[x][y] < matrix[nx][ny] && !visited[nx][ny]) {
                len = Math.max(len , dfs(matrix, nx, ny, res, visited));
            }
        }
        // 恢复
        visited[x][y] = false;
        // 再加上(x,y)自己的长度
        res[x][y] = len + 1;
        return res[x][y];
    }
}
