// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
// Runtime: 4 ms, faster than 100.00%
// Memory Usage: 42.9 MB, less than 99.54%

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Deque<int[]> queue = new ArrayDeque();

        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0,1}};

        maze[entrance[0]][entrance[1]] = 'v';
        queue.offer(new int[] {entrance[0], entrance[1]});

        int pathlen = 0;
        while (queue.size() > 0) {
            int sz = queue.size();
            for (int i=0; i<sz; i++) {
                int[] coord = queue.poll();
                int x = coord[0];
                int y = coord[1];

                if ((x == 0 || y == 0 || x == m-1 || y == n-1) && !(x == entrance[0] && y == entrance[1])) {
                    return pathlen;
                }

                for (int[] dir : dirs) {
                    int x_ = x + dir[0];
                    int y_ = y + dir[1];
                    if (x_ < 0 || x_ >= m || y_ < 0 || y_ >= n)
                        continue;
                    if (maze[x_][y_] == '.') {
                        queue.offer(new int[] {x_, y_});
                        maze[x_][y_] = 'v';
                    }
                }
            }
            pathlen++;
            // System.out.printf("%s, %s\n", pathlen, sz);
        }

        return -1;
    }
}
