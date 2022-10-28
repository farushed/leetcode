// https://leetcode.com/problems/detonate-the-maximum-bombs
// Runtime: 115 ms, faster than 87.86%
// Memory Usage: 42.5 MB, less than 85.43%

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        
        // first need to make directed graph ... aka array of lists of bombs each bomb detonates
        relations = new List[bombs.length];
        
        for (int i=0; i<n; i++) {
            List<Integer> ls = new LinkedList<>();
            for (int j=0; j<n; j++) {
                if (bombs[i] != bombs[j] && detonates(bombs[i], bombs[j]))
                    ls.add(j);
            }
            relations[i] = ls;
        }
        
        // now go through each bomb and find how many bombs it affects
        int maxSize = 0;
        for (int i=0; i<n; i++) {
            visited = new boolean[n];
            maxSize = Math.max(maxSize, dfs(i));
        }
        
        return maxSize;
    }
    
    List<Integer>[] relations;
    boolean[] visited;
    
    public int dfs(int cur) {
        visited[cur] = true;
        int count = 1;
        
        for (int c : relations[cur])
            if (!visited[c])
                count += dfs(c);
        
        return count;
    }
    
    public boolean detonates(int[] self, int[] other) {
        return Math.pow(self[2], 2) >= Math.pow(self[0] - other[0], 2) + Math.pow(self[1] - other[1], 2);
    }
}
