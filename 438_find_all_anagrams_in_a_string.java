// https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Runtime 9 ms Beats 73.35%
// Memory 43.2 MB Beats 85.64%

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length())
            return result;

        // frequencies of characters in p
        int[] counts = new int[26];
        for (char c : p.toCharArray())
            counts[c-'a']++;
        // to save us from checking 26 values every time
        int numZeros = 0;
        for (int i=0; i<26; i++)
            numZeros += (counts[i] == 0) ? 1 : 0;

        for (int i=0; i<s.length(); i++) {
            // track the character as appeared
            // we want the frequencies to be equal - so we store s1Freq-s2Freq and want it to be == 0
            int n = --counts[s.charAt(i)-'a'];
            if (n == 0) numZeros++;
            else if (n == -1) numZeros--;

            if (i - p.length() >= 0) {
                // remove the character just outside the sliding window
                n = ++counts[s.charAt(i-p.length())-'a'];
                if (n == 0) numZeros++;
                else if (n == 1) numZeros--;

            }

            if (i-p.length()+1 >= 0 && numZeros == 26)
                result.add(i-p.length()+1);
        }

        return result;
    }
}
