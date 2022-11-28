// https://leetcode.com/problems/find-players-with-zero-or-one-losses/
// Runtime: 88 ms, faster than 94.46%
// Memory Usage: 108.3 MB, less than 82.64%

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losers = new HashMap<>();

        for (int[] match : matches) {
            losers.putIfAbsent(match[0], 0);
            losers.compute(match[1], (k, v) -> (v==null) ? 1 : v+1);
        }

        List<Integer> noLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        for (int k : losers.keySet()) {
            if (losers.get(k) == 0)
                noLoss.add(k);
            else if (losers.get(k) == 1)
                oneLoss.add(k);
        }
        Collections.sort(noLoss);
        Collections.sort(oneLoss);
        return List.of(noLoss, oneLoss);
    }
}
