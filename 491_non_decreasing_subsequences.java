// https://leetcode.com/problems/non-decreasing-subsequences/
// Runtime 14 ms Beats 57.27%
// Memory 49.7 MB Beats 59.27%

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet();
        Deque<Integer> cur = new ArrayDeque();

        helper(0, nums, result, cur);

        return new ArrayList(result);
    }

    void helper(int idx, int[] nums, Set<List<Integer>> result, Deque<Integer> cur) {
        if (idx >= nums.length) {
            if (cur.size() >= 2)
                result.add(new ArrayList(cur));
            return;
        }

        Integer last = cur.peekLast();
        if (last == null || nums[idx] >= last) {
            cur.addLast(nums[idx]);
            helper(idx+1, nums, result, cur);
            cur.removeLast();
        }

        helper(idx+1, nums, result, cur);
    }
}
