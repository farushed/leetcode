// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
// Runtime 0 ms Beats 100%
// Memory 41.8 MB Beats 94.75%

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
    int maxDiff;
    public int maxAncestorDiff(TreeNode root) {
        maxDiff = 0;

        recurse(root, root.val, root.val);

        return maxDiff;
    }

    public void recurse(TreeNode root, int curMax, int curMin) {
        if (root == null) return;
        int d = Math.max(Math.abs(curMax-root.val), Math.abs(curMin-root.val));
        maxDiff = Math.max(d, maxDiff);

        if (root.val > curMax) curMax = root.val;
        else if (root.val < curMin) curMin = root.val;
        recurse(root.left, curMax, curMin);
        recurse(root.right, curMax, curMin);
    }
}
