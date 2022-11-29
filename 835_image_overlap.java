// https://leetcode.com/problems/image-overlap/
// Runtime: 8 ms, faster than 97.29%
// Memory Usage: 41.5 MB, less than 98.26%

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        //n is <= 30 so can store full row in single int
        int n = img1.length;

        int[] img1_ = new int[n];
        int[] img2_ = new int[n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                img1_[i] <<= 1;
                img1_[i] |= img1[i][j];

                img2_[i] <<= 1;
                img2_[i] |= img2[i][j];
            }
        }

        int a = checkOverlapDownLeftRight(img1_, img2_, n);
        int b = checkOverlapDownLeftRight(img2_, img1_, n);
        return Math.max(a, b);
    }

    public int checkOverlapDownLeftRight(int[] imgA, int[] imgB, int n) {
        int maxOverlap = 0;
        for (int down=0; down<n; down++) {
            for (int lr=0; lr<n; lr++) {
                int overlapR = 0;
                int overlapL = 0;
                for (int i=down; i<n; i++) {
                    overlapR += count((imgA[i-down] >> lr) & imgB[i]); // right
                    overlapL += count((imgA[i-down] << lr) & imgB[i]); // left
                }
                maxOverlap = Math.max(maxOverlap, Math.max(overlapR, overlapL));
            }
        }

        return maxOverlap;
    }

    public int count(int n) {
         int count = 0;
         while (n != 0) {
             n = n & (n-1);
             count++;
         }
         return count;
    }
}
