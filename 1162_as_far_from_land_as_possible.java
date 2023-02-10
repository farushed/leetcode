// https://leetcode.com/problems/as-far-from-land-as-possible/
// Runtime 15 ms Beats 72.46%
// Memory 43.4 MB Beats 60.36%

class Solution {
    final int[][] DIRS = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int maxDistance(int[][] grid) {
        int n = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                if (grid[i][j] == 1)
                    queue.offer(new int[]{i, j});
        
        if (queue.size() == n*n || queue.size() == 0)
            return -1;

        int distance = -1;
        while (!queue.isEmpty()) {
            int s = queue.size();
            while (s-- > 0) {
                int[] cur = queue.poll();
                for (int[] dir : DIRS) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < n
                            && grid[x][y] == 0) {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 1; // mark as land (visited)
                    }
                }
            }
            distance++;
        }

        return distance;
    }
}
