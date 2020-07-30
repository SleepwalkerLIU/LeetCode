package GreedyAlgorithm;

public class IntegerBreak {
    /**
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     * 说明: 你可以假设 n 不小于 2 且不大于 58。
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int a = 1;
        while (n > 4) {
            n -= 3;
            a *= 3;
        }
        return a * n;
    }
}
