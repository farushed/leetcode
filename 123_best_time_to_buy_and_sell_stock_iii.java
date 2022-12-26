// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
// Runtime 2 ms Beats 99.90%
// Memory 58.2 MB Beats 88.52%

class Solution {
    public int maxProfit(int[] prices) {
        int t1sell = 0, t1buy = -prices[0];
        int t2sell = 0, t2buy = -prices[0];

        for (int i=1; i<prices.length; i++) {
            t2sell = Math.max(t2sell, t2buy+prices[i]);
            t2buy  = Math.max(t2buy, t1sell-prices[i]);
            t1sell = Math.max(t1sell, t1buy+prices[i]);
            t1buy  = Math.max(t1buy, -prices[i]);
        }

        return t2sell;
    }
}
