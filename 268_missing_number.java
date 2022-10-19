// https://leetcode.com/problems/missing-number
// Runtime: 1 ms, faster than 86.15
// Memory Usage: 51.1 MB, less than 51.28%

class Solution {
    public int missingNumber(int[] nums) {
        int x = 0;
        int i = 0;
        while (i<nums.length) {
            x ^= i;
            x ^= nums[i];
            i++;
        }
        x ^= i;
        return x;
    }
}
