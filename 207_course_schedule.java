// https://leetcode.com/problems/course-schedule/
// Runtime 3 ms Beats 90.38%
// Memory 42.8 MB Beats 55.97%

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i=0; i<numCourses; i++)
            graph[i] = new ArrayList<>();
        for (int[] prereq : prerequisites)
            graph[prereq[0]].add(prereq[1]);
        
        boolean[] visited = new boolean[numCourses];
        for (int i=0; i<numCourses; i++) {
            boolean[] dfsStack = new boolean[numCourses];
            if (dfsContainsCycle(i, visited, dfsStack, graph))
                return false;
        }

        return true; // no cycles
    }

    public boolean dfsContainsCycle(int cur, boolean[] visited, boolean[] dfsStack, List<Integer>[] graph) {
        if (dfsStack[cur])
            return true;
        if (visited[cur])
            return false;

        visited[cur] = true;
        dfsStack[cur] = true;

        for (int nei : graph[cur])
            if (dfsContainsCycle(nei, visited, dfsStack, graph))
                return true;

        // due to directed graph, two paths to one node not necessarily cycle
        dfsStack[cur] = false;

        return false;
    }
}
