// https://leetcode.com/problems/edit-distance/
// Runtime 3 ms Beats 99.97%
// Memory 42.8 MB Beats 25.18%

class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] memo = new Integer[word1.length()+1][word2.length()+1];
        return helper(word1, word2, word1.length(), word2.length(), memo);
    }

    int helper(String w1, String w2, int l1, int l2, Integer[][] memo) {
        if (l1 == 0)
            return l2;
        if (l2 == 0)
            return l1;

        if (memo[l1][l2] != null)
            return memo[l1][l2];

        int res = Integer.MAX_VALUE;
        if (w1.charAt(l1-1) == w2.charAt(l2-1)) {
            res = helper(w1, w2, l1-1, l2-1, memo);
        } else {
            // insert to w2
            res = Math.min(res, 1+helper(w1, w2, l1-1, l2, memo));
            // delete from w2
            res = Math.min(res, 1+helper(w1, w2, l1, l2-1, memo));
            // replace either
            res = Math.min(res, 1+helper(w1, w2, l1-1, l2-1, memo));
        }

        memo[l1][l2] = res;
        return res;
    }
}
