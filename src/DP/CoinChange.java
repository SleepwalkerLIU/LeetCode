package DP;

public class CoinChange {
    /**
     * 已知不同面值的钞票，求如 何用最少数量的钞票组成某个金额，求可 以使用的最少钞票数量。
     * 如果任意数量的已知面值钞票都无法组成该金额， 则返回-1。
     * @param coins
     * @param amount
     * @return
     */
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
