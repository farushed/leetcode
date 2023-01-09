// https://leetcode.com/problems/binary-tree-preorder-traversal/
// Runtime 0 ms Beats 100%
// Memory 40.5 MB Beats 75.53%

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList();
        dfs(root, traversal);
        return traversal;
    }

    private void dfs(TreeNode root, List<Integer> traversal) {
        if (root == null)
            return;
        traversal.add(root.val);
        dfs(root.left, traversal);
        dfs(root.right, traversal);
    }
}
