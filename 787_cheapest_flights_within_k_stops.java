// https://leetcode.com/problems/cheapest-flights-within-k-stops/
// Runtime 10 ms Beats 40.73%
// Memory 42.5 MB Beats 98.58%

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Destination>[] graph = new List[n];
        for (int i=0; i<n; i++)
            graph[i] = new ArrayList<>();
        for (int[] flight : flights)
            graph[flight[0]].add(new Destination(flight[1], flight[2]));

        int[] prices = new int[n];
        for (int i=0; i<n; i++)
            prices[i] = Integer.MAX_VALUE;
        prices[src] = 0;

        for (int f=0; f<=k; f++) {
            int[] nextPrices = new int[n];
            for (int i=0; i<n; i++)
                nextPrices[i] = prices[i];

            for (int i=0; i<n; i++) {
                if (prices[i] == Integer.MAX_VALUE)
                    continue;
                for (Destination nei : graph[i]) {
                    if (prices[i] + nei.price < nextPrices[nei.city])
                        nextPrices[nei.city] = prices[i] + nei.price;
                }
            }
            prices = nextPrices;
        }

        return (prices[dst] == Integer.MAX_VALUE) ? -1 : prices[dst];
    }

    class Destination {
        int city, price;
        public Destination(int c, int p) {
            city = c; price = p;
        }
    }
}
