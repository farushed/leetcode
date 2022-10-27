// https://leetcode.com/problems/number-of-1-bits/
// Runtime: 1 ms, faster than 86.10%
// Memory Usage: 41.1 MB, less than 60.74%

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
//        int count = 0;
//        while (n != 0) {
//            n = n & (n-1);
//            count++;
//        }
//        return count;

        n = (n & 0x55555555) + (n>>1  & 0x55555555);
        n = (n & 0x33333333) + (n>>2  & 0x33333333);
        n = (n & 0x0f0f0f0f) + (n>>4  & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + (n>>8  & 0x00ff00ff);
        n = (n & 0x0000ffff) + (n>>16 & 0x0000ffff);
        return n;
    }
}
