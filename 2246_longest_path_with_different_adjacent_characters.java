// https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
// Runtime 201 ms Beats 48.86%
// Memory 126.6 MB Beats 51.14%

class Solution {
    public int longestPath(int[] parent, String s) {
        List<Integer>[] graph = new List[parent.length];
        for (int i=0; i<parent.length; i++)
            graph[i] = new ArrayList();
        for (int i=1; i<parent.length; i++) {
            graph[i].add(parent[i]);
            graph[parent[i]].add(i);
        }

        int[] max = new int[1];

        int r = dfs(-1, 0, graph, s, max);

        return Math.max(r, max[0]);
    }

    int dfs(int from, int cur, List<Integer>[] graph, String s, int[] max) {
        Queue<Integer> maxes = new PriorityQueue(Collections.reverseOrder());

        for (int n : graph[cur]) {
            if (n == from) continue;
            int r = dfs(cur, n, graph, s, max);
            if (s.charAt(n) != s.charAt(cur))
                maxes.offer(r);
        }

        int tmp = 1;
        if (maxes.size() >= 1) {
            tmp += maxes.poll();
            max[0] = Math.max(max[0], tmp);
            if (maxes.size() >= 1) {
                max[0] = Math.max(max[0], tmp + maxes.poll());
            }
        }

        return tmp;
    }
}
