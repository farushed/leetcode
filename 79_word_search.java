// https://leetcode.com/problems/word-search/
// Runtime: 168 ms, faster than 64.42%
// Memory Usage: 42.3 MB, less than 46.50%

class Solution {
    private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (dfs(board, word, visited, i, j, 0))
                    return true;
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int depth) {
        if (visited[i][j] || word.charAt(depth) != board[i][j])
            return false;
        
        if (depth == word.length()-1)
            return true;
        
        visited[i][j] = true;
        
        for (int[] d : directions) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                if (dfs(board, word, visited, ni, nj, depth+1)) {
                    visited[i][j] = false;
                    return true;
                }
            }
        }
        
        visited[i][j] = false;
        return false;
    }
}
