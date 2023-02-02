// https://leetcode.com/problems/verifying-an-alien-dictionary/
// Runtime 0 ms Beats 100%
// Memory 40.5 MB Beats 98.90%

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[order.length()];
        for (int i=0; i<order.length(); i++)
            map[order.charAt(i)-'a'] = i;

        for (int i=0; i<words.length-1; i++) {
            if (compare(words[i], words[i+1], map) > 0)
                return false;
        }

        return true;
    }

    private int compare(String a, String b, int[] map) {
        int end = Math.min(a.length(), b.length());
        for (int i=0; i<end; i++) {
            int diff = map[a.charAt(i)-'a'] - map[b.charAt(i)-'a'];
            if (diff != 0)
                return diff;
        }
        return a.length() - b.length();
    }
}
