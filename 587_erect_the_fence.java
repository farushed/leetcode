// https://leetcode.com/problems/erect-the-fence/
// Runtime: 149 ms, faster than 6.45% of Java online submissions for Erect the Fence.
// Memory Usage: 44.1 MB, less than 80.65% of Java online submissions for Erect the Fence.

class Solution {
    public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 3)
            return trees;
        
        Set<int[]> hull = new HashSet<>();
        
        int[] leftmost = trees[0];
        for (int[] tree : trees) {
            if (tree[0] < leftmost[0])
                leftmost = tree;
        }
        
        int[] cur = leftmost;
        double lastAngle = Math.atan2(1, 0);
        
        do {
            double largestAngle = -999;
            int[] largest = null;
            // System.out.printf("(%s, %s)\n", cur[0], cur[1]);
            for (int[] tree : trees) {
                if (tree == cur) continue;
                if (hull.contains(tree)) continue;
                // System.out.printf("- (%s, %s)\n", tree[0], tree[1]);
                double angle = Math.atan2(tree[1]-cur[1], tree[0]-cur[0]);
                if (lastAngle <= 0 && angle > 0) angle -= 2*Math.PI;
                if ( (angle <= lastAngle && angle > largestAngle)
                || (angle == largestAngle && distSq(cur, tree) < distSq(cur, largest)) ) {
                    largestAngle = angle;
                    largest = tree;
                }
            }
            if (largestAngle <= -Math.PI) largestAngle += 2*Math.PI;
            lastAngle = largestAngle;
            cur = largest;
            hull.add(cur);
        } while (cur != leftmost);
        
        hull.add(leftmost);
        
        return hull.toArray(new int[0][0]);
    }
    
    private double distSq(int[] x, int[] y) {
        return (y[0]-x[0])*(y[0]-x[0]) + (y[1]-x[1])*(y[1]-x[1]);
    }
}
