// https://leetcode.com/problems/number-of-islands/
// Runtime: 3 ms, faster than 97.44%
// Memory Usage: 58.1 MB, less than 15.95%

class Solution {
    public void dfs(char[][] g, int x, int y, int n, int m) {
        if (g[y][x] == '0') {
            return;
        }

        g[y][x] = '0';

        if (x-1 >= 0)
            dfs(g, x-1, y, n, m);
        if (x+1 < n)
            dfs(g, x+1, y, n, m);
        if (y-1 >= 0)
            dfs(g, x, y-1, n, m);
        if (y+1 < m)
            dfs(g, x, y+1, n, m);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[j][i] == '1')
                {
                    dfs(grid, i, j, n, m);

                    count += 1;
                }
            }
        }
        return count;
    }
}
