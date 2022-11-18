// https://leetcode.com/problems/ugly-number/
// Runtime: 1 ms, faster than 100.00%
// Memory Usage: 39.3 MB, less than 95.62%

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n != 1) {
            if ((n % 2) == 0)
                n /= 2;
            else if ((n % 3) == 0)
                n /= 3;
            else if ((n % 5) == 0)
                n /= 5;
            else
                return false;
        }
        return true;
    }
}
