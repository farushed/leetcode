// https://leetcode.com/problems/minimum-distance-between-bst-nodes/
// Runtime 0 ms Beats 100% 
// Memory 39.6 MB Beats 92.86%

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
    public int minDiffInBST(TreeNode root) {
        return minDiff(root, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    int minDiff(TreeNode root, int leftVal, int rightVal) {
        int result = Math.min(Math.abs(leftVal-root.val),
                            Math.abs(rightVal-root.val));
        if (root.left != null)
            result = Math.min(result, minDiff(root.left, leftVal, root.val));
        if (root.right != null)
            result = Math.min(result, minDiff(root.right, root.val, rightVal));
        return result;
    }
}
