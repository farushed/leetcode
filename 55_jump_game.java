// https://leetcode.com/problems/jump-game/
// Runtime: 1 ms, faster than 100.00%
// Memory Usage: 42.8 MB, less than 89.92%

class Solution {
    public boolean canJump(int[] nums) {
        int furthest = nums[0];
        int l = nums.length;
        for (int i=0; i<=furthest; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            if (furthest >= l-1)
                return true;
        }
        return false;
    }
}
