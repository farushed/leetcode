// https://leetcode.com/problems/possible-bipartition/
// Runtime 27 ms Beats 82.46%
// Memory 69.1 MB Beats 72.19%

class Solution {
    private int[] uf;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        uf = new int[n+1];
        int[] map = new int[n+1];
        for (int i=0; i<n; i++) {
            uf[i] = 0;
            map[i] = 0;
        }

        for (int[] d : dislikes) {
            int a = d[0]; int fa = find(a);
            int b = d[1]; int fb = find(b);
            if (fa == 0) { // a not connected to anything
                if (fb == 0) { // b also not connected
                    map[b] = a;
                    map[a] = b;
                    uf[b] = b;
                    fb = b;
                }
                uf[a] = a;
                union(a, map[fb]);
            } else if (fb == 0) { // a connected, b not connected
                uf[b] = b;
                union(b, map[fa]);
            } else { // both connected
                union(map[fb], fa); // fa new root
                union(map[fa], fb); // fb new root
                map[fa] = fb;
                map[fb] = fa;
            }
            // System.out.printf("a %d, find(a) %d, b %d, find(b) %d\n", a, find(a), b, find(b));
            if (find(a) == find(b))
                return false; // we connected two in the same group
        }

        return true;
    }

    private void union(int i, int j) {
        uf[find(i)] = find(j);
    }

    private int find(int i) {
        while (uf[i] != i)
            i = uf[i];
        return i;
    }
}
