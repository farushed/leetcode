// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
// Runtime 1 ms Beats 90.22%
// Memory 40.8 MB Beats 80.79%

class Solution {
    public int maxProfit(int[] prices) {
        int[] prev = new int[3];
        prev[0] = 0; // no stock, ready to buy
        prev[1] = -prices[0]; // held
        prev[2] = 0; // just sold

        for (int i=1; i<prices.length; i++) {
            int[] cur = new int[3];
            cur[0] = Math.max(prev[0], prev[2]); // previous day was rest or cooldown
            cur[1] = Math.max(prev[0]-prices[i], prev[1]); // previous day rest+buy now, or keep holding
            cur[2] = prev[1]+prices[i]; // sell+cooldown
            prev = cur;
        }

        return Math.max(prev[0], prev[2]);
    }
}
