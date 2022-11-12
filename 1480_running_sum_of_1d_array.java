// https://leetcode.com/problems/running-sum-of-1d-array/
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 43.4 MB, less than 46.11%

class Solution {
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            int prev = (i==0) ? 0 : runningSum[i-1];
            runningSum[i] = prev + nums[i];
        }
        return runningSum;
    }
}
