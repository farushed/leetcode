// https://leetcode.com/problems/rotate-image/
// Runtime: 0 ms
// Memory Usage: 42.8 MB, less than 43.52%

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int x = n/2 + n%2;
        int y = n/2;

        for (int i=0; i<x; i++) {
            for (int j=0; j<y; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[n-1-i][j];
                matrix[n-1-i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }
}
