// https://leetcode.com/problems/powx-n/
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 41.5 MB, less than 91.11%

class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n < 0)
            return 1.0 / (x * myPow(x, -(n+1))); // for annoying negation overflow case

        if ((n & 1) == 1)
            return x * myPow(x, n-1);
        return myPow(x*x, n/2);
    }
}
