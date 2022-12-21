// https://leetcode.com/problems/possible-bipartition/
// Runtime 11 ms Beats 98.86%
// Memory 49.3 MB Beats 99.82%

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n+1];
        for (int i=1; i<=n; i++)
            graph[i] = new ArrayList();

        for (int[] d : dislikes) {
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }

        int[] cols = new int[n+1];
        for (int i=0; i<=n; i++)
            cols[i] = -1;

        for (int i=1; i<=n; i++) {
            if (cols[i] == -1 && !colour(graph, cols, i, 0))
                return false;
        }
        return true;
    }

    private boolean colour(List<Integer>[] graph, int[] cols, int i, int col) {
        if (cols[i] >= 0)
            return cols[i] == col;

        cols[i] = col;
        int otherCol = col == 0 ? 1 : 0;

        for (int j=0; j<graph[i].size(); j++)
            if (!colour(graph, cols, graph[i].get(j), otherCol))
                return false;

        return true;
    }
}
