package DP;

public class LengthOfLIS {
    /**
     * 已知一个未排序数组，求这个数组最长上升子序列的长度。
     * 例如: [1, 3, 2, 3, 1, 4]， 其中有很多上升子序列，如[1, 3]、[1, 2, 3]、 [1, 2, 3, 4]等，其中最长的上升子序列长度为4。
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int res = dp[0];
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
