// https://leetcode.com/problems/find-if-path-exists-in-graph/
// Runtime 14 ms Beats 97.88%
// Memory 137.4 MB Beats 85.41%

class Solution {
    private int[] uf;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        uf = new int[n];

        for (int i=0; i<n; i++)
            uf[i] = i;

        for (int[] edge : edges)
            uf[findRoot(edge[1])] = findRoot(edge[0]);

        return findRoot(source) == findRoot(destination);
    }

    int findRoot(int i) {
        while (uf[i] != i)
            i = uf[i];
        return i;
    }
}
