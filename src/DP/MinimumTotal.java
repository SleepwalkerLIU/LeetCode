package DP;

import java.util.List;

public class MinimumTotal {
    /**
     * 给定一个二维数组，其保存了一个数字三角形 triangleMatrix[] []，
     * 求从数字三角形顶端到底端各数字和最小的路径之和，每次可以向下走相邻的两个位置
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
