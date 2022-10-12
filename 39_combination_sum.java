// https://leetcode.com/problems/combination-sum
// Runtime: 2 ms, faster than 99.39%
// Memory Usage: 42.8 MB, less than 88.86%

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();

        Arrays.sort(candidates);
        dfs(candidates, target, 0, cur, res);

        return res;
    }

    // assumes candidates are sorted, this just helps us start and end the loop faster
    // we will check from candidateIdx (to avoid counting 2,2,3 and also 2,3,2 for example)
    // through to the largest candidate less than or equal to target
    // note: cur acts as a stack and we add/remove element 0
    // (most efficient option with List interface and LinkedList implementation)
    private void dfs(int[] candidates, int target, int candidateIdx, List<Integer> cur, List<List<Integer>> res){
        for (int i=candidateIdx; i<candidates.length && candidates[i]<=target; i++) {
            int num = candidates[i];
            cur.add(0, num); // push
            if (num == target) {
                res.add(new LinkedList<>(cur));
            } else {
                dfs(candidates, target-num, i, cur, res);
            }
            cur.remove(0); // pop
        }
    }
}
