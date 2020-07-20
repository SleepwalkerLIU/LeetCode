package DP;

public class HouseRobber {
    /**
     * 在一条直线上，有n个房屋，每个房屋中有数量不等的财宝，有一个盗 贼希望从房屋中盗取财宝，
     * 由于房屋中有报警器，如果同时从相邻的两个房屋中盗取财宝就会触发报警器。
     * 问在不触发报警器的前提下，最多可获取多少财宝？
     * 例如 [5，2，6，3，1，7]，则选择5，6，7
     * @param nums
     * @return
     */
    public int houseRobber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int[] flags = new int[nums.length];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = (nums[0] > nums[1]) ? nums[0] : nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = ((nums[i] + dp[i - 2]) > dp[i - 1]) ? (nums[i] + dp[i - 2]) : dp[i - 1];
        }
        return dp[nums.length - 1];
    }
}
