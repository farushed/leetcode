// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// Runtime 1 ms Beats 95.78%
// Memory 42.1 MB Beats 93.63%

class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;

        for (int i=1; i<prices.length; i++) {
            if (prices[i] > prices[i-1])
                total += prices[i] - prices[i-1];
        }

        return total;
    }
}
