// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
// Runtime 4 ms Beats 100%
// Memory 50.2 MB Beats 100%

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (node1 == node2)
            return node1; // annoying edge case

        boolean[] visited1 = new boolean[edges.length];
        boolean[] visited2 = new boolean[edges.length];
        visited1[node1] = true;
        visited2[node2] = true;

        while (node1 != -1 || node2 != -1) {
            int candidate = Integer.MAX_VALUE;

            if (node1 != -1) {
                node1 = edges[node1]; // traverse the only directed edge
                if (node1 != -1) {
                    if (visited2[node1]) // this must be the first common node
                        candidate = node1;
                    else if (visited1[node1]) // cycle, no point exploring more
                        node1 = -1;
                    else
                        visited1[node1] = true;
                }
            }

            if (node2 != -1) {
                node2 = edges[node2];
                if (node2 != -1) {
                    if (visited1[node2])
                        candidate = Math.min(candidate, node2); // smallest index if clash
                    else if (visited2[node2])
                        node2 = -1;
                    else
                        visited2[node2] = true;
                }
            }

            if (candidate != Integer.MAX_VALUE) {
                return candidate;
            }
        }

        return -1;
    }
}
