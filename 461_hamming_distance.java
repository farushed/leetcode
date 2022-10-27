// https://leetcode.com/problems/hamming-distance/
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 40.9 MB, less than 48.11%

class Solution {
    public int hammingDistance(int x, int y) {
        x ^= y; // hamming weight of x XOR y

        int count = 0;
        while (x != 0) {
            x &= (x-1);
            count++;
        }
        return count;
    }
}
