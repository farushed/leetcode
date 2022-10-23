// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Runtime: 2 ms, faster than 99.08%
// Memory Usage: 42.1 MB, less than 90.20%

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
    Map<Integer, Integer> m;
    int preorderIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        m = new HashMap<>();
        for (int i=0; i<inorder.length; i++)
            m.put(inorder[i], i);
        preorderIdx = 0;

        return buildTree(preorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int ii, int ij) {
        if (ii > ij)
            return null;

        int val = preorder[preorderIdx++];
        TreeNode root = new TreeNode(val);

        int idx = m.get(val);
        root.left = buildTree(preorder, ii, idx-1);
        root.right = buildTree(preorder, idx+1, ij);
        return root;
    }
}
