// https://leetcode.com/problems/counting-bits/
// Runtime: 1 ms, faster than 99.97%
// Memory Usage: 45.9 MB, less than 99.53%

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;

        if (n == 0)
            return ans;

        int curPow2 = 1;
        for (int i=1; i<n+1; i++) {
            if (i >= curPow2 * 2)
                curPow2 *= 2;
            ans[i] = 1 + ans[i-curPow2];
        }

        return ans;
    }
}
