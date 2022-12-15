// https://leetcode.com/problems/longest-common-subsequence/
// Runtime 13 ms Beats 91.71%
// Memory 46 MB Beats 79.1%

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (i==0 && j==0)
                    dp[0][0] = (text1.charAt(0) == text2.charAt(0)) ? 1 : 0;
                else if (i==0)
                    dp[0][j] = Math.max(dp[0][j-1], (text1.charAt(0) == text2.charAt(j)) ? 1 : 0);
                else {
                    if (text1.charAt(i) == text2.charAt(j))
                        dp[i][j] = ((j>0) ? dp[i-1][j-1] : 0) + 1;
                    else
                        dp[i][j] = Math.max((j>0) ? dp[i][j-1] : 0, dp[i-1][j]);
                }
            }
        }

        return dp[n-1][m-1];
    }
}
