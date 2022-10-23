// https://leetcode.com/problems/binary-tree-level-order-traversal/
// Runtime: 1 ms, faster than 94.10%
// Memory Usage: 42.5 MB, less than 86.54%

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null)
            return ret;

        List<TreeNode> level = new LinkedList<>();
        List<Integer> levelVals = new LinkedList<>();
        level.add(root);
        levelVals.add(root.val);

        while (!level.isEmpty()) {
            ret.add(levelVals);
            levelVals = new LinkedList<>();
            List<TreeNode> nextLevel = new LinkedList<>();

            for (TreeNode n : level) {
                if (n.left != null) {
                    nextLevel.add(n.left);
                    levelVals.add(n.left.val);
                }
                if (n.right != null) {
                    nextLevel.add(n.right);
                    levelVals.add(n.right.val);
                }
            }

            level = nextLevel;
        }

        return ret;
    }
}
