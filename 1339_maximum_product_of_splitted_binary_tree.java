// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
// Runtime 54 ms Beats 11.65%
// Memory 60.3 MB Beats 79.24%

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeSet<Long> sums;

    final long MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        sums = new TreeSet();

        long overallSum = sumTree(root);
        long halfOverallSum = overallSum/2;

        long maxProductModded = -1;
        long prevDiff = Long.MAX_VALUE;
        Iterator<Long> it = sums.iterator();
        while (it.hasNext()) {
            long a = it.next();
            long b = overallSum - a;

            long diff = Math.abs(a - b);
            // System.out.printf("%d, %d... %d %d\n", a, b, diff, prevDiff);
            if (diff > prevDiff) {
                break;
            }
            maxProductModded = ((a % MOD) * (b % MOD)) % MOD; // calculated here so will break before it when condition above

            prevDiff = diff;
        }

        return (int) maxProductModded;
    }

    private long sumTree(TreeNode root) {
        if (root == null) return 0;
        long sum = root.val + sumTree(root.left) + sumTree(root.right);
        sums.add(sum);
        return sum;
    }
}
