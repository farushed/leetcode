// https://leetcode.com/problems/maximum-sum-circular-subarray/
// Runtime 5 ms Beats 60.60%
// Memory 49.8 MB Beats 51.72%

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int suffixSum = nums[n-1];
        int[] suffixMax = new int[n+1];
        suffixMax[n] = 0; // for easier loop later
        suffixMax[n-1] = suffixSum;
        for (int i=n-2; i>=0; i--) {
            suffixSum += nums[i];
            suffixMax[i] = Math.max(suffixSum, suffixMax[i+1]);
        }

        int prefixSum = nums[0];
        int maxSum = nums[0] + suffixMax[1];

        int sumNormal = nums[0];
        maxSum = Math.max(maxSum, nums[0]);

        for (int i=1; i<n; i++) {
            // normal kadane's
            sumNormal = Math.max(sumNormal, 0) + nums[i];

            prefixSum += nums[i];
            maxSum = Math.max(maxSum, Math.max(sumNormal, prefixSum + suffixMax[i+1]));
        }

        return maxSum;
    }
}
