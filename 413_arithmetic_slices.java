// https://leetcode.com/problems/arithmetic-slices/
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 40 MB, less than 95.37%

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;

        int cur = 0;
        int total = 0;

        for (int i=2; i<nums.length; i++) {
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                // triangular numbers
                cur += 1;
                total += cur;
            } else {
                cur = 0;
            }
        }

        return total;
    }
}
