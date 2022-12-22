// https://leetcode.com/problems/sum-of-distances-in-tree/
// Runtime 41 ms Beats 96.65%
// Memory 61.5 MB Beats 91.87%

class Node {
    int num;
    List<Node> children;
    int sumBelow = 0;
    int count = 0;

    public Node(int num) {
        this.num = num;
        this.children = new ArrayList();
    }
}

class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        Node[] nodes = new Node[n];
        for (int i=0; i<n; i++)
            nodes[i] = new Node(i);

        for (int[] edge : edges) {
            nodes[edge[0]].children.add(nodes[edge[1]]);
            nodes[edge[1]].children.add(nodes[edge[0]]);
        }
        removeBackReferences(nodes[0]);

        countAndSum(nodes[0]);

        int[] answer = new int[n];
        int sum = nodes[0].sumBelow;
        answer[0] = sum;
        for (Node c : nodes[0].children) {
            dfs(c, sum, n, answer);
        }

        return answer;
    }

    private void dfs(Node root, int parentSum, int totalCount, int[] answer) {
        // answer[root.n] = root.sumBelow + (parentSum - (root.sumBelow + root.count) + n - root.count)
        int sum = parentSum - 2*root.count + totalCount;
        answer[root.num] = sum;

        for (Node c : root.children) {
            dfs(c, sum, totalCount, answer);
        }
    }

    private void countAndSum(Node root) {
        root.sumBelow = 0;
        root.count = 1;

        for (Node c : root.children) {
            countAndSum(c);
            root.sumBelow += c.sumBelow + c.count;
            root.count += c.count;
        }
    }

    private void removeBackReferences(Node root) {
        for (Node c : root.children) {
            c.children.remove(root);
            removeBackReferences(c);
        }
    }
}
