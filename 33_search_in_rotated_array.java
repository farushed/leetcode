// https://leetcode.com/problems/search-in-rotated-sorted-array/
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 41.6 MB, less than 97.80%

class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;

        while (i <= j) {
            int m = (i+j)/2;
            if (nums[m] == target)
                return m;

            if (nums[i] <= nums[m]) {
                if (nums[i] <= target && target < nums[m])
                    j = m-1;
                else
                    i = m+1;
            } else {
                if (nums[m] < target && target <= nums[j])
                    i = m+1;
                else
                    j = m-1;
            }
        }
        return -1;
    }

    // Runtime: 4 ms, faster than 5.14%
    // Memory Usage: 42.1 MB, less than 76.45%
//     public int search(int[] nums, int target) {
//         int i;
//         int j;

//         if (nums[0] < nums[nums.length-1] || nums.length==1) {
//             i = 0;
//             j = nums.length-1;
//         } else {
//             int k = findPivot(nums);
//             System.out.println(k);
//             if (target < nums[0]) {
//                 i = k+1;
//                 j = nums.length-1;
//             } else {
//                 i = 0;
//                 j = k;
//             }
//         }
//         while (i <= j) {
//             int m = (i+j)/2;
//             if (target == nums[m])
//                 return m;
//             else if (target > nums[m])
//                 i = m+1;
//             else
//                 j = m-1;
//         }

//         return -1;
//     }

//     public int findPivot(int[] nums) {
//         int i = 0;
//         int j = nums.length-1;

//         while (i <= j) {
//             int m = (i+j)/2;
//             if (nums[m] > nums[m+1])
//                 return m;
//             else if (nums[m] >= nums[0])
//                 i = m+1;
//             else
//                 j = m-1;
//         }
//         return -1;
//     }
}
