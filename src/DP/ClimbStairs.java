package DP;

/**
 * 在爬楼梯时，每次可向上走1阶台阶或2阶台阶，问有n阶楼 梯有多少种上楼的方式？
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
