// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
// Runtime 67 ms Beats 94.51%
// Memory 124.1 MB Beats 86.81%

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] graph = new List[n];
        for (int[] edge : edges) {
            if (graph[edge[0]] == null) graph[edge[0]] = new ArrayList();
            if (graph[edge[1]] == null) graph[edge[1]] = new ArrayList();
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] result = new int[n];

        dfs(-1, 0, graph, labels, result);

        return result;
    }

    private int[] dfs(int from, int cur, List<Integer>[] graph, String labels, int[] result) {
        int[] counts = new int[26];
        counts[labels.charAt(cur)-'a'] += 1;

        for (int n : graph[cur]) {
            if (n == from) continue;

            int[] ret = dfs(cur, n, graph, labels, result);
            for (int i=0; i<26; i++)
                counts[i] += ret[i];
        }

        result[cur] = counts[labels.charAt(cur)-'a'];

        return counts;
    }
}
