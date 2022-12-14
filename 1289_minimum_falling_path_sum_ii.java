// https://leetcode.com/problems/minimum-falling-path-sum-ii/
// Runtime 52 ms Beats 59.38%
// Memory 49.7 MB Beats 81.24%

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        for (int row=n-2; row>=0; row--) {
            for (int col=0; col<n; col++) {
                int m = Integer.MAX_VALUE;
                for (int col2=0; col2<n; col2++)
                    if (col2 != col)
                        m = Math.min(m, grid[row+1][col2]);
                grid[row][col] += m;
            }
        }

        int result = grid[0][0];
        for (int col=1; col<n; col++)
            result = Math.min(result, grid[0][col]);

        return result;
    }
}
