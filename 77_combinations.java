// https://leetcode.com/problems/combinations
// Runtime: 2 ms, faster than 98.64%
// Memory Usage: 45.1 MB, less than 85.99%

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> stack = new LinkedList<>();

        helper(1, n, k, stack, res);

        return res;
    }

    public void helper(int i, int n, int k, List<Integer> stack, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new LinkedList<>(stack));
            return;
        }
        if (i > n) {
            return;
        }

        for (; i <= n-k+1; i++) {
            stack.add(0, i);
            helper(i+1, n, k-1, stack, res);
            stack.remove(0);
        }
    }
}
