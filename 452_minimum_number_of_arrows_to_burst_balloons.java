// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
// Runtime 69 ms Beats 82.59%
// Memory 79.2 MB Beats 81.33%

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int popCoord = points[0][1];

        for (int i=1; i<points.length; i++) {
            if (points[i][0] <= popCoord) // && popCoord <= points[i][1] // implied by sort
                continue; // also popped
            arrows += 1;
            popCoord = points[i][1];
        }

        return arrows;
    }
}
