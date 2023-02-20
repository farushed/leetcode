// https://leetcode.com/problems/search-insert-position/
// Runtime 0 ms Beats 100%
// Memory 41.6 MB Beats 93.24%

class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi-lo)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                lo = mid+1;
            else
                hi = mid-1;
        }

        return lo;
    }
}
