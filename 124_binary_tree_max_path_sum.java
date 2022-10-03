// https://leetcode.com/problems/binary-tree-maximum-path-sum/
// Runtime: 1 ms, faster than 99.78%
// Memory Usage: 46.7 MB, less than 84.46%

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
    public int maxPathSum(TreeNode root) {
        result = -9999; // outside valid range
        result = Math.max(mps(root), result); // call mps first (which calculates result), then max with this result
        return result;
    }
    
    private int result;
    
    private int mps(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int m1, m2;
        m1 = mps(root.left);
        m2 = mps(root.right);
        
        int t = root.val;
        if (m1 > 0) t += m1;
        if (m2 > 0) t += m2;
        if (t > result) result = t;
        
        int m = Math.max(m1, m2);
        if (m < 0)
            m = 0;
        return m + root.val;
    }
}
