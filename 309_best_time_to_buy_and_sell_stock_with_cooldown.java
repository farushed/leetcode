// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
// Runtime 40 ms Beats 5%
// Memory 42 MB Beats 68.62%

class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int[] dpMax = new int[prices.length];

        for (int i=prices.length-1; i>=0; i--) {
            dp[i] = 0;
            for (int j=i+1; j<prices.length; j++) {
                int m = Math.max(dp[j-1], dp[j]);
                m = Math.max(m, prices[j]-prices[i]);
                dp[j] = m;
            }

            int j = prices.length-1;
            int m = dp[j];
            for (int k=i+1; k+2<j; k++) {
                m = Math.max(m, dp[k] + dpMax[k+2]);
            }
            dp[j] = m;
            dpMax[i] = m;
        }
        // System.out.println(Arrays.toString(dp));
        // System.out.println(Arrays.toString(dpMax));
        return dpMax[0];
    }
}
