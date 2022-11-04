// https://leetcode.com/problems/clone-graph/
// Runtime: 25 ms, faster than 99.66%
// Memory Usage: 42.3 MB, less than 90.72%

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        return dfs(node, new HashMap<>());
    }

    public Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node))
            return map.get(node);

        Node copy = new Node(node.val);
        map.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }

        return copy;
    }
}
