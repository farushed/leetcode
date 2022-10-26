// https://leetcode.com/problems/unique-paths-iii/
// Runtime: 0 ms, faster than 100.00
// Memory Usage: 39.6 MB, less than 94.40%

class Solution {
    public int m, n;
    
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        int sx = 0;
        int sy = 0;
        int pathlen = 0;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int val = grid[i][j];
                if (val == 1) {
                    sx = i;
                    sy = j;
                } else if (val == 0) {
                    pathlen += 1;
                }
            }
        }
        grid[sx][sy] = 0;
        return uniquePathsIII(grid, sx, sy, pathlen+1);
    }
            
    public int uniquePathsIII(int[][] grid, int cx, int cy, int pathlen) {
        if (cx < 0 || cx >= m || cy < 0 || cy >= n || grid[cx][cy] == 1 || grid[cx][cy] == -1)
            return 0;
        if (grid[cx][cy] == 2) {
            return (pathlen == 0) ? 1 : 0;
        }
        
        int count = 0;
        grid[cx][cy] = 1;
        count += uniquePathsIII(grid, cx, cy+1, pathlen-1);
        count += uniquePathsIII(grid, cx, cy-1, pathlen-1);
        count += uniquePathsIII(grid, cx+1, cy, pathlen-1);
        count += uniquePathsIII(grid, cx-1, cy, pathlen-1);
        grid[cx][cy] = 0;
        
        return count;
    }

// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 39.1 MB, less than 100.00%

//    public int m, n;
//    public int startR, startC, endR, endC;
//    
//    public int uniquePathsIII(int[][] grid) {
//        m = grid.length;
//        n = grid[0].length;
//        
//        int[] bitgrid = new int[m];
//        for (int i=0; i<m; i++) {
//            for (int j=0; j<n; j++) {
//                int val = grid[i][j];
//                if (val == 1) {
//                    startR = i;
//                    startC = j;
//                } else if (val == 2) {
//                    endR = i;
//                    endC = j;
//                } else if (val == -1) {
//                    bitgrid[i] |= (1 << j);
//                }
//            }
//        }
//        
//        return uniquePathsIII(bitgrid, startR, startC);
//    }
//            
//    public int uniquePathsIII(int[] bitgrid, int curR, int curC) {
//        if (curR < 0 || curR >= m || curC < 0 || curC >= n || (bitgrid[curR] & (1 << curC)) != 0)
//            return 0;
//        if (curR == endR && curC == endC) {
//            bitgrid[curR] |= (1 << curC);
//            boolean res = bitgridFull(bitgrid);
//            bitgrid[curR] &= ~(1 << curC);
//            return res ? 1 : 0;
//        }
//        
//        int count = 0;
//        bitgrid[curR] |= (1 << curC);
//        count += uniquePathsIII(bitgrid, curR, curC+1);
//        count += uniquePathsIII(bitgrid, curR, curC-1);
//        count += uniquePathsIII(bitgrid, curR+1, curC);
//        count += uniquePathsIII(bitgrid, curR-1, curC);
//        bitgrid[curR] &= ~(1 << curC);
//        
//        return count;
//    }
//    
//    public boolean bitgridFull(int[] bitgrid) {
//        // lets say n is 3, a full bitgrid would have each row as 0b111
//        // 0b111 + 1 == 0b1000 == (1 << 3)
//        for (int i=0; i<m; i++) {
//            if (bitgrid[i] + 1 != (1 << n))
//                return false;
//        }
//        return true;
//    }
}
