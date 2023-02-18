// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
// Runtime 50 ms Beats 67.80%
// Memory 109.4 MB Beats 60.17%

class Solution {
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i=0; i<n; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        long total = 0;
        long componentsSum = 0;
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++) {
            if (visited[i])
                continue;
            long count = dfs(i, visited, graph);
            total += componentsSum * count;
            componentsSum += count;
        }

        return total;
    }

    long dfs(int cur, boolean[] visited, List<Integer>[] graph) {
        long count = 1;
        visited[cur] = true;
        for (int nei : graph[cur])
            if (!visited[nei])
                count += dfs(nei, visited, graph);
        return count;
    }
}
