// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
// Runtime 1 ms Beats 100%
// Memory 40.5 MB Beats 96.2%

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // init UF
        int[] groups = new int[26];
        for (int i=0; i<26; i++)
            groups[i] = i;

        // build equivalence classes
        for (int i=0; i<s1.length(); i++)
            union(groups, s1.charAt(i)-'a', s2.charAt(i)-'a');

        // build smallest equivalent string
        StringBuilder result = new StringBuilder(baseStr.length());

        for (int i=0; i<baseStr.length(); i++)
            result.append((char) (find(groups, baseStr.charAt(i)-'a')+'a'));

        return result.toString();
    }

    int find(int[] uf, int i) {
        while (i != uf[i]) {
            i = uf[i] = uf[uf[i]]; // path compression
        }
        return i;
    }

    void union(int[] uf, int a, int b) {
        a = find(uf, a);
        b = find(uf, b);
        uf[Math.max(a, b)] = Math.min(a, b); // smaller char gets set as parent
    }
}
