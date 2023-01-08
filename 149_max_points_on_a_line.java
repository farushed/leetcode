// https://leetcode.com/problems/max-points-on-a-line/
// Runtime 14 ms Beats 95.81%
// Memory 42.1 MB Beats 80.95%

class Solution {
    public int maxPoints(int[][] points) {
        int max = 0;

        for (int[] fixed : points) {
            Map<Double, Integer> slopes = new HashMap();
            for (int[] other : points) {
                if (fixed == other) continue;
                double dx = other[0] - fixed[0]; // division by 0 goes to +-inf
                int dy = other[1] - fixed[1];

                // +1 point on line with the given slope
                int count = slopes.merge(dy/dx, 1, (a,b)->a+b);
                max = Math.max(max, count);
            }
        }

        return max+1; // account for fixed point
    }
}
