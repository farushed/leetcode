// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
// Runtime 64 ms Beats 55.29%
// Memory 83.6 MB Beats 89.41%

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = new HashMap();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList());
            graph.putIfAbsent(edge[1], new ArrayList());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return 2 * dfs(-1, 0, graph, hasApple);
    }

    private int dfs(int from, int cur, Map<Integer, List<Integer>> graph, List<Boolean> hasApple) {
        int count = 0;
        for (int n : graph.get(cur)) {
            if (n == from)
                continue;
            count += dfs(cur, n, graph, hasApple);
        }

        if (cur != 0 && (count != 0 || hasApple.get(cur)))
            count += 1;

        return count;
    }
}
