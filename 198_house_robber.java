// https://leetcode.com/problems/house-robber/
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 39.8 MB, less than 89.00%

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        int r = 0;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }
}
