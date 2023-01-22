// https://leetcode.com/problems/palindrome-partitioning/
// Runtime 9 ms Beats 90.92%
// Memory 54.8 MB Beats 64.84%

class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] palindromeMemo = new boolean[s.length()][s.length()];
        List<List<String>> result = new ArrayList();
        List<String> cur = new ArrayList();

        helper(s, 0, cur, result, palindromeMemo);

        return result;
    }


    void helper(String s, int idx, List<String> cur, List<List<String>> result, boolean[][] palindromeMemo) {
        if (idx == s.length()) {
            // if we get here, all elements of cur are necessarily palindromes
            result.add(new ArrayList(cur));
            return;
        }

        for (int j=idx; j<s.length(); j++) {
            // check if palindrome
            // palindromeMemo[idx+1] available as we recurse there on first iteration (when j=idx so idx+2>=j)
            if (s.charAt(idx) == s.charAt(j) && (idx+2 >= j || palindromeMemo[idx+1][j-1])) {
                palindromeMemo[idx][j] = true;
                // recurse and backtrack
                cur.add(s.substring(idx, j+1));
                helper(s, j+1, cur, result, palindromeMemo);
                cur.remove(cur.size()-1);
            }
        }
    }
}
