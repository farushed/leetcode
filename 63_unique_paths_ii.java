// https://leetcode.com/problems/unique-paths-ii/
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 40.3 MB, less than 93.12%

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m-1][n-1] == 1)
            return 0; // goal blocked

        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (obstacleGrid[r][c] == 1)
                    obstacleGrid[r][c] = -1;
            }
        }

        obstacleGrid[m-1][n-1] = 1;

        for (int r=m-1; r>=0; r--) {
            for (int c=n-1; c>=0; c--) {
                if (obstacleGrid[r][c] == -1) { // obstacle already here
                    obstacleGrid[r][c] = 0;
                } else {
                    obstacleGrid[r][c] = obstacleGrid[r][c] // start it off
                                       + ((c+1<n) ? obstacleGrid[r][c+1] : 0)
                                       + ((r+1<m) ? obstacleGrid[r+1][c] : 0);
                }
            }
        }

        return obstacleGrid[0][0];
    }
}
