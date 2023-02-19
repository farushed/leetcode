// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// Runtime 1 ms Beats 87.41%
// Memory 40.9 MB Beats 69.29%

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        boolean flip = false;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            LinkedList<Integer> vals = new LinkedList<>();

            int qs = q.size();
            while (qs-- > 0) {
                TreeNode cur = q.poll();
                if (cur.left != null)   q.offer(cur.left);
                if (cur.right != null)  q.offer(cur.right);

                if (flip)   vals.addFirst(cur.val);
                else        vals.addLast(cur.val);
            }

            flip = !flip;
            result.add(vals);
        }

        return result;
    }
}
