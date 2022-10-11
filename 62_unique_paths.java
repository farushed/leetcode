// https://leetcode.com/problems/unique-paths/
// Runtime: 0 ms, faster than 100.0%
// Memory Usage: 40.9 MB, less than 45.99%

class Solution {
    public int uniquePaths(int m, int n) {
        if (m < n) {
            int tmp = n;
            n = m;
            m = tmp;
        }

        int[] dp = new int[n];
        for (int j=0; j<m; j++) {
            for (int i=0; i<n; i++) {
                if (i==0) {
                    dp[i] = 1;
                } else if (j==0) {
                    dp[i] = 1;
                } else {
                    dp[i] = dp[i-1] + dp[i];
                }
            }
        }
        return dp[n-1];
    }
}
