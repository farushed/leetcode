// https://leetcode.com/problems/climbing-stairs/
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 38.8 MB, less than 98.13%

class Solution {
    public int climbStairs(int n) {
        int ways = 1;
        int waysLess = 0;

        int tmp;
        for (int i=0; i<n; i++) {
            tmp = ways;
            ways = ways + waysLess;
            waysLess = tmp;
        }

        return ways;
    }
}
