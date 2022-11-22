// https://leetcode.com/problems/perfect-squares/
// Runtime: 37 ms, faster than 82.64%
// Memory Usage: 42.8 MB, less than 72.92%

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];

        int[] squares = new int[(int)(Math.sqrt(n))+1];
        for (int i=1; i<=squares.length; i++) {
            squares[i-1] = i*i;
        }

        dp[0] = 0;
        for (int i=1; i<=n; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int sq : squares) {
                if (i-sq >= 0)
                    minVal = Math.min(minVal, 1+dp[i-sq]);
                else
                    break;
            }
            dp[i] = minVal;
        }

        return dp[n];
    }
}
