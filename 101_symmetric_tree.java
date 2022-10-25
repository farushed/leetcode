// https://leetcode.com/problems/symmetric-tree/

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
    public boolean isSymmetric(TreeNode root) {
        // iterative
        // Runtime: 1 ms, faster than 76.67%
        // Memory Usage: 42.4 MB, less than 35.54%
        Deque<TreeNode> ltree = new LinkedList<>();
        Deque<TreeNode> rtree = new LinkedList<>();

        if (root.left != null) ltree.offer(root.left);
        if (root.right != null) rtree.offer(root.right);

        while (!ltree.isEmpty() && !rtree.isEmpty()) {
            TreeNode ln = ltree.poll();
            TreeNode rn = rtree.poll();
            if (ln == null && rn == null)
                ; // skip to next iter
            else if (ln == null || rn == null)
                return false;
            else if (ln.val != rn.val)
                return false;
            else {
                ltree.offer(ln.left);
                ltree.offer(ln.right);
                rtree.offer(rn.right);
                rtree.offer(rn.left);
            }
        }

        return ltree.isEmpty() == rtree.isEmpty();

    }

    // recursive
    // Runtime: 0 ms, faster than 100.00%
    // Memory Usage: 40.2 MB, less than 98.00%
//     public boolean isSymmetric(TreeNode root) {
//         return isMirror(root.left, root.right);
//     }

//     public boolean isMirror(TreeNode a, TreeNode b) {
//         if (a == null || b == null)
//             return a == b;
//         return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
//     }
}
