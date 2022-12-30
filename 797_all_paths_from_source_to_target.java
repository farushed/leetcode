// https://leetcode.com/problems/all-paths-from-source-to-target/
// Runtime 1 ms Beats 100%
// Memory 44 MB Beats 87.92%

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList();

        dfs(graph, 0, new ArrayList<Integer>(), result);

        return result;
    }

    public void dfs(int[][] graph, int cur, List<Integer> path, List<List<Integer>> result) {
        path.add(cur);

        if (cur == graph.length-1) {
            result.add(new ArrayList(path)); // copy
        } else {
            for (int n : graph[cur]) {
                dfs(graph, n, path, result);
            }
        }

        path.remove(path.size()-1);
    }
}
