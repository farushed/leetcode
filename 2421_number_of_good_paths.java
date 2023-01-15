// https://leetcode.com/problems/number-of-good-paths/
// Runtime121 ms Beats 81.20%
// Memory63.1 MB Beats 85.71%

class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;

        // init graph
        List<Integer>[] graph = new List[n];
        for (int i=0; i<n; i++)
            graph[i] = new ArrayList();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // init nodes sorted by their val
        Integer[] sortedNodes = new Integer[n];
        for (int i=0; i<n; i++)
            sortedNodes[i] = i;
        Arrays.sort(sortedNodes, Comparator.comparing(a->vals[a]));
        System.out.println(Arrays.toString(sortedNodes));

        // init UF
        UnionFind uf = new UnionFind(n);


        // actual algorithm
        int totalPaths = 0;
        int prevIdx = -1;
        int prevVal = -1;

        for (int nodeIdx=0; nodeIdx<n; nodeIdx++) {
            int node = sortedNodes[nodeIdx];
            int val = vals[node];

            // if we just finished a run of identical vals
            if (val != prevVal) {
                if (prevIdx != -1) {
                    // go over nodes with same val, count how many are in each connected subgraph
                    Map<Integer, Integer> counts = new HashMap();
                    for (int i=prevIdx; i<nodeIdx; i++)
                        counts.merge(uf.find(sortedNodes[i]), 1, (a,b)->a+b);
                    // and add the corresponding number of paths for each
                    for (int count : counts.values())
                        totalPaths += count*(count-1)/2;
                }
                prevIdx = nodeIdx;
            }

            // union all smaller neighbours (that we are free to traverse)
            for (int nei : graph[node])
                if (vals[nei] <= val)
                    uf.union(node, nei);

            prevVal = val;
        }

        // process remaining
        if (prevIdx != -1) {
            Map<Integer, Integer> counts = new HashMap();
            for (int i=prevIdx; i<n; i++)
                counts.merge(uf.find(sortedNodes[i]), 1, (a,b)->a+b);
            for (int count : counts.values())
                totalPaths += count*(count-1)/2;
        }

        // need to add on the n 0-length paths
        return totalPaths + n;
    }

}

class UnionFind {
    int[] groups;

    UnionFind(int size) {
        groups = new int[size];

        for (int i=0; i<size; i++) {
            groups[i] = i;
        }
    }

    int find(int i) {
        while (i != groups[i])
            i = groups[i] = groups[groups[i]];
        return i;
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);

        groups[a] = b;
    }
}
