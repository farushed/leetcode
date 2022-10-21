// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
// Runtime: 3 ms, faster than 76.89%
// Memory Usage: 76.2 MB, less than 81.83%

class Solution {
    public int maxProfit(int[] prices) {
        int curMaxSell = 0;
        int maxProfit = 0;
        for (int i=prices.length-1; i>=0; i--) {
            curMaxSell = Math.max(curMaxSell, prices[i]);
            maxProfit = Math.max(maxProfit, curMaxSell-prices[i]);
        }
        return maxProfit;
    }
}
