// https://leetcode.com/problems/implement-trie-prefix-tree/
// Runtime: 44 ms, faster than 89.61% of Java online submissions for Implement Trie (Prefix Tree).
// Memory Usage: 52.4 MB, less than 90.37% of Java online submissions for Implement Trie (Prefix Tree).

class Trie {

    public class TrieNode {
        private Map<Character, TrieNode> m;
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
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.set(ch);
            node = node.get(ch);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.get(ch);
            if (node == null)
                return false;
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.get(ch);
            if (node == null)
                return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
