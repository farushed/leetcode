// https://leetcode.com/problems/combination-sum-ii
// Runtime: 3 ms, faster than 96.32%
// Memory Usage: 42.4 MB, less than 96.23%

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();

        Arrays.sort(candidates);
        dfs(candidates, target, 0, cur, res);

        return new ArrayList<>(res);
    }

    // assumes candidates are sorted, this just helps us start and end the loop faster
    // we will check from candidateIdx (to avoid counting 2,2,3 and also 2,3,2 for example)
    // through to the largest candidate less than target
    // note: cur acts as a stack and we add/remove element 0
    // (most efficient option with List interface and LinkedList implementation)
    private void dfs(int[] candidates, int target, int candidateIdx, List<Integer> cur, List<List<Integer>> res){
        for (int i=candidateIdx; i<candidates.length && candidates[i]<=target; i++) {
            if (i != candidateIdx && candidates[i] == candidates[i-1]) {
                continue; // skip duplicates
            }

            int num = candidates[i];
            cur.add(0, num); // push
            if (num == target) {
                res.add(new LinkedList<>(cur));
            } else {
                dfs(candidates, target-num, i+1, cur, res);
            }
            cur.remove(0); // pop
        }
    }
}
