// https://leetcode.com/problems/minimum-falling-path-sum/
// Runtime 4 ms Beats 74.68%
// Memory 42.7 MB Beats 94.31%

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int row=n-2; row>=0; row--) {
            for (int col=0; col<n; col++) {
                int m = matrix[row+1][col];
                if (col > 0)
                    m = Math.min(m, matrix[row+1][col-1]);
                if (col < n-1)
                    m = Math.min(m, matrix[row+1][col+1]);
                matrix[row][col] += m;
            }
        }

        int result = matrix[0][0];
        for (int col=1; col<n; col++)
            result = Math.min(result, matrix[0][col]);

        return result;
    }
}
