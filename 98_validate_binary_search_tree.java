// https://leetcode.com/problems/validate-binary-search-tree
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 42.1 MB, less than 85.43%

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
    public boolean isValidBST(TreeNode root) {
        if (root.right != null)
            if ( ! (isValidBST(root.right) && min(root.right) > root.val) )
                return false;

        if (root.left != null)
            if (! (isValidBST(root.left) && max(root.left) < root.val) )
                return false;

        return true;
    }

    public int max(TreeNode root) {
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    public int min(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    // from reading discussion this seems like a much nicer method
    // but since the height of the tree is O(log N) finding max and min every time isnt terrible for leetcode testcases
    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, null, null);
    }

    public boolean isValidBST2(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if ((max != null && root.val >= max.val) || (min != null && root.val <= min.val)) return false;
        return isValidBST2(root.left, min, root) && isValidBST2(root.right, root, max);
    }
}
