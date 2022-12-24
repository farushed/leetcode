// https://leetcode.com/problems/domino-and-tromino-tiling/
// Runtime 0 ms Beats 100%
// Memory 39.3 MB Beats 87.20%

class Solution {
    final int MOD = 1000000007;

    public int numTilings(int n) {
        if (n < 3) return n;

        int dp0 = 1;
        int dp1 = 1;
        int dp2 = 2;
        for (int i=3; i<=n; i++) {
            int dp3 = ((dp2*2) % MOD + dp0) % MOD;
            dp0 = dp1;
            dp1 = dp2;
            dp2 = dp3;
        }

        return dp2 % MOD;
    }
}
