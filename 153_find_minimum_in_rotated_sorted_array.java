// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 42 MB, less than 85.44%

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length-1])
            return nums[0];

        int i = 0;
        int j = nums.length-1;

        while (i <= j) {
            int m = (i+j)/2;
            if (nums[m] > nums[m+1])
                return nums[m+1];
            else if (nums[m] >= nums[0])
                i = m+1;
            else
                j = m-1;
        }
        return -1;
    }
}
