// https://leetcode.com/problems/sum-of-distances-in-tree/
// Runtime 290 ms Beats 8.13%
// Memory 85.3 MB Beats 68.90%

class Solution {
    Map<Integer, Integer>[] dfsMemo;
    Map<Integer, Integer>[] countMemo;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        dfsMemo = new Map[n];
        countMemo = new Map[n];

        for (int i=0; i<n; i++) {
            graph[i] = new ArrayList();
            dfsMemo[i] = new HashMap();
            countMemo[i] = new HashMap();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }


        int[] answer = new int[n];

        for (int i=0; i<n; i++) {
            answer[i] = dfs(-1, i, graph);
        }
            
        return answer;
    }

    private int dfs(int from, int cur, List<Integer>[] graph) {
        if (dfsMemo[cur].containsKey(from))
            return dfsMemo[cur].get(from);

        int result = 0;

        for (int nei : graph[cur]) {
            if (nei != from)
                result += count(cur, nei, graph) + dfs(cur, nei, graph);
        }

        dfsMemo[cur].put(from, result);
        return result;
    }

    private int count(int from, int cur, List<Integer>[] graph) {
        if (countMemo[cur].containsKey(from))
            return countMemo[cur].get(from);

        int c = 1;

        for (int nei : graph[cur]) {
            if (nei != from)
                c += count(cur, nei, graph);
        }

        countMemo[cur].put(from, c);
        return c;
    }
}
