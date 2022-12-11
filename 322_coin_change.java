// https://leetcode.com/problems/coin-change/
// Runtime 17 ms Beats 92.56%
// Memory 41.7 MB Beats 95.67%

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins); // so we can break as soon as coins too big in loop
        int[] dp = new int[amount+1];

        dp[0] = 0;
        for (int i=1; i<=amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i-c < 0)
                    break;
                if (dp[i-c] != -1)
                    min = Math.min(min, dp[i-c] + 1);
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return dp[amount];
    }
}
