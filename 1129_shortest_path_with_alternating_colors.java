// https://leetcode.com/problems/shortest-path-with-alternating-colors/
// Runtime 4 ms Beats 89.50%
// Memory 43 MB Beats 57.76%

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // graph[node][colour] with 0=red, 1=blue
        int[] answer = new int[n];
        List<Integer>[][] graph = new List[n][];
        for (int i=0; i<n; i++) {
            answer[i] = -1;
            graph[i] = new List[]{new ArrayList<>(), new ArrayList<>()};
        }

        for (int[] edge : redEdges)
            graph[edge[0]][0].add(edge[1]);
        for (int[] edge : blueEdges)
            graph[edge[0]][1].add(edge[1]);

        // bfs on {node, last_colour} with last_colour 0=red, 1=blue
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][2];

        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        visited[0][0] = true;
        visited[0][1] = true;

        int pathlen = 0;
        while (!queue.isEmpty()) {
            int s = queue.size();

            while (s-- > 0) {
                int[] cur = queue.poll();
                int newColour = 1-cur[1];

                if (answer[cur[0]] == -1)
                    answer[cur[0]] = pathlen;

                for (int nei : graph[cur[0]][newColour]) {
                    if (!visited[nei][newColour]) {
                        visited[nei][newColour] = true;
                        queue.offer(new int[]{nei, newColour});
                    }
                }
            }

            pathlen++;
        }

        return answer;
    }
}
