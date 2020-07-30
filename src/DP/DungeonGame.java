package DP;

import java.util.Arrays;

public class DungeonGame {
    /**
     * 已知一个二维数组，左上角代表骑士的位置，右下角代表公主的位置，
     * 二维数组中存储整数，正数可以给骑士增加生命值，负数会减少骑士的生命值，
     * 问骑士初始时至少是多少生命值，才可保证骑士在行走的过程中至少保持生命值为1。(骑士只能向下或向右行走)
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[n][m-1] = dp[n-1][m] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int minHP = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(minHP - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
