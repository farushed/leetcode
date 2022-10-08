// https://leetcode.com/problems/maximum-product-subarray/
// Runtime: 3 ms, faster than 52.55%
// Memory Usage: 44.9 MB, less than 39.58%

class Solution {
    public int maxProduct(int[] nums) {
        int overallMax = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            int num = nums[i];
            
            int tmp = Math.max(Math.max(curMax*num, curMin*num), num);
            curMin = Math.min(Math.min(curMax*num, curMin*num), num);
            curMax = tmp;
            
            if (curMax > overallMax)
                overallMax = curMax;
        }
        
        return overallMax;
    }
}
