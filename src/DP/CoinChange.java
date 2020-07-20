package DP;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if (len == 0 || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < len; i++) {
            if (coins[i] == amount) {
                return 1;
            }
            if (coins[i] < amount) {
                dp[coins[i]] = 1;
            }
        }
        // State Transfer Function
        for (int i = 1; i <= amount; i++) {
            for (int j : coins) {
                if (i - j >= 0 && dp[i - j] != -1) {
                    if (dp[i] == -1 || dp[i] > dp[i - j] + 1) {
                        dp[i] = dp[i - j] + 1;
                    }
                }
            }
        }

        return dp[amount];
    }
}
