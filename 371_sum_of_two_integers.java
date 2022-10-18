// https://leetcode.com/problems/sum-of-two-integers/
// Runtime: 0 ms
// Memory Usage: 41.8 MB

class Solution {
    public int getSum(int a, int b) {
        int x, y;

        while (b != 0) {
            x = a ^ b;
            y = (a & b) << 1;
            a = x; b = y;
        }

        return a;
    }
}
