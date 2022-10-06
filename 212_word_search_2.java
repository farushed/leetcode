// https://leetcode.com/problems/word-search-ii
// Runtime: 1153 ms, faster than 17.34%
// Memory Usage: 45 MB, less than 36.98%

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                dfs(board, visited, res, new StringBuilder(), trie, i, j);

        return res;
    }

    private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    private void dfs(char[][] board, boolean[][] visited, List<String> res, StringBuilder curWord, Trie trie, int i, int j) {
        if (visited[i][j])
            return;

        visited[i][j] = true;
        curWord.append(board[i][j]);

        if (trie.search(curWord)) {
            res.add(curWord.toString());
            trie.remove(curWord);
        }
        if (trie.startsWith(curWord)) {
            int m = board.length;
            int n = board[0].length;
            for (int[] d : directions) {
                int ni = i + d[0];
                int nj = j + d[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    dfs(board, visited, res, curWord, trie, ni, nj);
                }
            }
        }

        curWord.deleteCharAt(curWord.length()-1);
        visited[i][j] = false;
    }
}

// my solution from https://leetcode.com/problems/implement-trie-prefix-tree/submissions/
// converted to work with StringBuilder as well as String
// and added remove method
class Trie {

    public class TrieNode {
        public Map<Character, TrieNode> m;
        public boolean isEnd;

        public TrieNode() {
            m = new HashMap<>();
        }

        public TrieNode get(char ch) {
            return m.get(ch);
        }

        public void set(char ch) {
            m.putIfAbsent(ch, new TrieNode());
        }

        public void remove(char ch) {
            m.remove(ch);
        }

        public int size() {
            return m.size();
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(CharSequence word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            node.set(ch);
            node = node.get(ch);
        }
        node.isEnd = true;
    }

    public void remove(CharSequence word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            node = node.get(word.charAt(i));
            if (node == null)
                return;
        }
        node.isEnd = false;
        if (node.size() > 0) {
            return;
        }

        int lasti = -1; // so if no 'last' nodes found, will remove the first char of word from root
        TrieNode last = root;
        node = root;
        for (int i=0; i<word.length(); i++) {
            node = node.get(word.charAt(i));
            if (node == null)
                return;
            if (node.isEnd || node.size()>1) {
                last = node;
                lasti = i;
            }
        }
        if (lasti+1 < word.length()) {
            last.remove(word.charAt(lasti+1));
        }
    }

    public boolean search(CharSequence word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            node = node.get(word.charAt(i));
            if (node == null)
                return false;
        }
        return node.isEnd;
    }

    public boolean startsWith(CharSequence prefix) {
        TrieNode node = root;
        for (int i=0; i<prefix.length(); i++) {
            node = node.get(prefix.charAt(i));
            if (node == null)
                return false;
        }
        return true;
    }
}
