package GreedyAlgorithm;

public class CanJump {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int res =nums[0];
        if (len <= 1) {
            return true;
        }
        for (int i = 1; i < len; i++) {
            if (i <= res) {
                res = Math.max(res, i + nums[i]);
            }
        }
        return  res >= len - 1;
    }
}
