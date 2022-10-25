// https://leetcode.com/problems/valid-sudoku/
// Runtime: 2 ms, faster than 97.56%
// Memory Usage: 45 MB, less than 82.99%

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check rows
        for (int row=0; row < 9; row++) {
            int digits = 0;
            for (int col=0; col < 9; col++) {
                char val = board[row][col];
                if (val != '.') {
                    int b = 1 << (val-'0');
                    if ((digits & b) != 0)
                        return false;
                    digits |= b;
                }
            }
        }
        
        // check columns
        for (int col=0; col < 9; col++) {
            int digits = 0;
            for (int row=0; row < 9; row++) {
                char val = board[row][col];
                if (val != '.') {
                    int b = 1 << (val-'0');
                    if ((digits & b) != 0)
                        return false;
                    digits |= b;
                }
            }
        }
        
        // check sub-boxes
        for (int subx=0; subx<3; subx++) {
            for (int suby=0; suby<3; suby++) {
                int digits = 0;
                
                for (int row=subx*3; row < (subx+1)*3; row++) {
                    for (int col=suby*3; col < (suby+1)*3; col++) {
                        char val = board[row][col];
                        if (val != '.') {
                            int b = 1 << (val-'0');
                            if ((digits & b) != 0)
                                return false;
                            digits |= b;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
