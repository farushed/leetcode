// https://leetcode.com/problems/path-sum-ii/
// Runtime: 1 ms, faster than 100.00%
// Memory Usage: 42.8 MB, less than 88.66%

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
    private void dfs(LinkedList<Integer> path, List<List<Integer>> allPaths, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        path.addLast(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                allPaths.add(List.copyOf(path));
            }
        } else {
            dfs(path, allPaths, root.left, targetSum-root.val);
            dfs(path, allPaths, root.right, targetSum-root.val);
        }
        path.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();

        dfs(new LinkedList<>(), res, root, targetSum);

        return res;
    }
}
