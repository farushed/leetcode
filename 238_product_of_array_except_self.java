// https://leetcode.com/problems/product-of-array-except-self/
// Runtime: 1 ms, faster than 100.00%
// Memory Usage: 50.5 MB, less than 91.34%

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] answer = new int[l];
        answer[l-1] = nums[l-1];
        for (int i=l-2; i>=0; i--) {
            answer[i] = nums[i] * answer[i+1];
        }
        int cumulative = 1;
        for (int i=0; i<l-1; i++) {
            answer[i] = cumulative * answer[i+1];
            cumulative *= nums[i];
        }
        answer[l-1] = cumulative;
        return answer;
    }
}
