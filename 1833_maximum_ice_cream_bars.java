// https://leetcode.com/problems/maximum-ice-cream-bars/
// Runtime 52 ms Beats 40.52%
// Memory 73.7 MB Beats 53.55%

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        for (int i=0; i<costs.length; i++) {
            coins -= costs[i];
            if (coins < 0)
                return i;
        }

        return costs.length;
    }
}
