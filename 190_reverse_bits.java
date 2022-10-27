// https://leetcode.com/problems/reverse-bits
// Runtime: 1 ms, faster than 98.55%
// Memory Usage: 42.4 MB, less than 59.33%

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i=0; i<32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
        }
        return res;
    }
}
