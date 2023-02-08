// https://leetcode.com/problems/jump-game-ii/
// Runtime 1 ms Beats 99.45%
// Memory 42.5 MB Beats 83.82%

class Solution {
    public int jump(int[] nums) {
        int furthest = 0;
        int jumps = 0;
        int cur = 0;

        while (furthest < nums.length-1) {
            int tmp = furthest;
            while (cur <= tmp) {
                furthest = Math.max(furthest, cur+nums[cur]);
                cur++;
            }
            jumps++;
        }

        return jumps;
    }
}
