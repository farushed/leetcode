// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
// Runtime 0 ms Beats 100%
// Memory 38.7 MB Beats 96.20%

class Solution {
    public int countOdds(int low, int high) {
        return (high-low)/2 + (low%2 + high%2 > 0 ? 1 : 0);
    }
}
