// https://leetcode.com/problems/maximum-subarray/
// Runtime: 1 ms, faster than 100.00%
// Memory Usage: 72.7 MB, less than 80.21%

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = -10000;
        int max = sum;

        for (int i=0; i<nums.length; i++) {
            sum = Math.max(nums[i], sum+nums[i]);
            if (sum > max) max = sum;
        }

        return max;
    }
}
