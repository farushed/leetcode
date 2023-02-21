// https://leetcode.com/problems/single-element-in-a-sorted-array/
// Runtime 0 ms Beats 100%
// Memory 59.8 MB Beats 11.59%

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = (nums.length-1)/2;

        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (mid*2+1<nums.length && nums[mid*2] == nums[mid*2+1])
                lo = mid+1;
            else if (mid>0 && nums[mid*2] == nums[mid*2-1])
                hi = mid-1;
            else
                return nums[mid*2];
        }

        return nums[lo*2];
    }
}
