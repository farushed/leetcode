// https://leetcode.com/problems/find-duplicate-subtrees/
// Runtime 3 ms Beats 99.71%
// Memory 42.7 MB Beats 98.34%

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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        helper(root, new HashMap<>(), new HashSet<>(), result);
        return result;
    }

    int helper(TreeNode root, Map<List<Integer>, Integer> tripletToID, Set<Integer> added, List<TreeNode> result) {
        if (root == null)
            return 0;

        List<Integer> triplet = List.of(
            helper(root.left, tripletToID, added, result),
            root.val,
            helper(root.right, tripletToID, added, result));
        Integer prev = tripletToID.putIfAbsent(triplet, tripletToID.size()+1);
        if (prev != null && !added.contains(prev)) { // was already in there
            added.add(prev);
            result.add(root);
        }

        return tripletToID.get(triplet);
    }
}
