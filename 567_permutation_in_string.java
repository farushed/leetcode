// https://leetcode.com/problems/permutation-in-string/
// Runtime 5 ms Beats 80.89%
// Memory 41.8 MB Beats 96.32%

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        // frequencies of characters in s1
        int[] counts = new int[26];
        for (char c : s1.toCharArray())
            counts[c-'a']++;
        // to save us from checking 26 values every time
        int numZeros = 0;
        for (int i=0; i<26; i++)
            numZeros += (counts[i] == 0) ? 1 : 0;

        for (int i=0; i<s2.length(); i++) {
            // track the character as appeared
            // we want the frequencies to be equal - so we store s1Freq-s2Freq and want it to be == 0
            int n = --counts[s2.charAt(i)-'a'];
            if (n == 0) numZeros++;
            else if (n == -1) numZeros--;

            if (i >= s1.length()) {
                // remove the character just outside the sliding window
                n = ++counts[s2.charAt(i-s1.length())-'a'];
                if (n == 0) numZeros++;
                else if (n == 1) numZeros--;

            }

            if (numZeros == 26)
                return true;
        }

        return false;
    }
}

