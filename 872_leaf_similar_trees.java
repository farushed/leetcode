// https://leetcode.com/problems/leaf-similar-trees/
// Runtime 0 ms Beats 100%
// Memory 40.1 MB Beats 88.24%

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> s1 = new ArrayList();
        List<Integer> s2 = new ArrayList();
        getLeafSeq(root1, s1);
        getLeafSeq(root2, s2);
        return s1.equals(s2);
    }

    public void getLeafSeq(TreeNode root, List<Integer> seq) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            seq.add(root.val);
            return;
        }
        getLeafSeq(root.left, seq);
        getLeafSeq(root.right, seq);
    }
}
