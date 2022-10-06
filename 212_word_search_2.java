// https://leetcode.com/problems/word-search-ii
// Runtime: 313 ms, faster than 52.67%
// Memory Usage: 42.2 MB, less than 98.14%

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();

        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.word = word;
        }

        for (int i=0; i<board.length; i++)
            for (int j=0; j<board[0].length; j++)
                dfs(board, res, root, i, j);

        return res;
    }

    private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    private void dfs(char[][] board, List<String> res, TrieNode node, int i, int j) {
        if (board[i][j] == '#')
            return;

        char cur = board[i][j];
        if (!node.children.containsKey(cur))
            return;
        node = node.children.get(cur);
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        char c = board[i][j];
        board[i][j] = '#';

        if (i < board.length-1)     dfs(board, res, node, i+1, j);
        if (i > 0)                  dfs(board, res, node, i-1, j);
        if (j < board[0].length-1)  dfs(board, res, node, i, j+1);
        if (j > 0)                  dfs(board, res, node, i, j-1);

        board[i][j] = c;
    }
}


public class TrieNode {
    public Map<Character, TrieNode> children;
    public String word;

    public TrieNode() {
        children = new HashMap<>();
    }
}
