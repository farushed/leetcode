// https://leetcode.com/problems/minimum-average-difference/
// Runtime: 23 ms, faster than 73.58%
// Memory Usage: 74.6 MB, less than 68.78%

class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        
        long upto = 0;
        long after = 0;
        for (int num : nums) after += num;
        
        long minAvgDiff = Long.MAX_VALUE;
        int minAvgDiffIdx = -1;
        
        for (int i=0; i<n; i++) {
            upto += nums[i];
            after -= nums[i];
            
            long avgDiff = Math.abs(upto/(i+1) - ((i+1 != n) ? after/(n-i-1) : 0));
            if (avgDiff < minAvgDiff) {
                minAvgDiff = avgDiff;
                minAvgDiffIdx = i;
            }
        }
        
        return minAvgDiffIdx;
    }
}
