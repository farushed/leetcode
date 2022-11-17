// https://leetcode.com/problems/rectangle-area/ 
// Runtime: 2 ms, faster than 100.00%
// Memory Usage: 41.7 MB, less than 84.83%

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2-ax1)*(ay2-ay1);
        int area2 = (bx2-bx1)*(by2-by1);

        int x = lineIntersection(ax1, ax2, bx1, bx2);
        int y = lineIntersection(ay1, ay2, by1, by2);

        return area1 + area2 - x*y;
    }

    public int lineIntersection(int a1, int a2, int b1, int b2) {
        int ret = Math.min(a2, b2) - Math.max(a1, b1);
        return Math.max(ret, 0);
    }
}
