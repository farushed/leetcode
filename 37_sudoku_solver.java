// https://leetcode.com/problems/sudoku-solver/
// Runtime: 11 ms, faster than 75.69%
// Memory Usage: 41.3 MB, less than 68.33%

class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0);
    }

    public boolean solveSudoku(char[][] board, int rowStart) {
        int row = -1;
        int col = -1;

        for (int i=rowStart; i<9 && row==-1; i++) {
            for (int j=0; j<9 && col==-1; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                }
            }
        }

        if (row == -1 && col == -1)
            return true; // complete

        for (int num=1; num<=9; num++) {
            if (canPlace(num, row, col, board)) {
                board[row][col] = (char) (num + '0');
                if (solveSudoku(board, row)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;
    }

    public boolean canPlace(int num, int row, int col, char[][] board) {
        char n = (char) (num + '0');

        for (int c=0; c<9; c++)
            if (board[row][c] == n) return false;

        for (int r=0; r<9; r++)
            if (board[r][col] == n) return false;

        int boxStartX = (col/3)*3;
        int boxStartY = (row/3)*3;
        for (int c=boxStartX; c<boxStartX+3; c++)
            for (int r=boxStartY; r<boxStartY+3; r++)
                if(board[r][c] == n) return false;

        return true;
    }
}
