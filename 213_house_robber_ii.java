// https://leetcode.com/problems/house-robber-ii/
// Runtime: 0 ms, less than 100.0%
// Memory Usage: 40.8 MB, less than 82.24%

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        int r = 0;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i=2; i<nums.length-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int a = dp[nums.length-1-1];

        // so basically do all the usual stuff up to but not including last el
        // then do everything but exclude the first el
        // and take the max

        dp = new int[nums.length];
        r = 0;
        dp[1] = nums[1];
        dp[2] = Math.max(nums[2], nums[1]);
        for (int i=3; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int b = dp[nums.length-1];

        return Math.max(a, b);
    }
}
