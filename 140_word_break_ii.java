// https://leetcode.com/problems/word-break-ii/
// Runtime 1 ms Beats 98.14%
// Memory 40.7 MB Beats 73.90%

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordsSet = new HashSet<>(wordDict);
        List<String> cur = new ArrayList<>();
        List<String> res = new ArrayList<>();

        backtrack(s, wordsSet, cur, res);

        return res;
    }

    void backtrack(String s, Set<String> wordsSet, List<String> cur, List<String> res) {
        if (wordsSet.contains(s)) {
            cur.add(s);
            res.add(String.join(" ", cur));
            cur.remove(cur.size()-1);
        }

        for (int i=1; i<s.length(); i++) {
            String sub = s.substring(0, i);
            if (wordsSet.contains(sub)) {
                cur.add(sub);
                backtrack(s.substring(i, s.length()), wordsSet, cur, res);
                cur.remove(cur.size()-1);
            }
        }
    }
}
