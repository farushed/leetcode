// https://leetcode.com/problems/subtree-of-another-tree/submissions/
// Runtime: 3 ms, faster than 97.60%
// Memory Usage: 42.6 MB, less than 86.59%

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null)
            return false;

        return isEqual(root, subRoot)
            || isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }

    public boolean isEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2 == null;
        if (t2 == null)
            return false;

        if (t1.val == t2.val)
            return isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
        return false;
    }
}
