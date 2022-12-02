// https://leetcode.com/problems/determine-if-two-strings-are-close/
// Runtime: 12 ms, faster than 97.80%
// Memory Usage: 42.9 MB, less than 95.59%

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        
        int[] charCounts1 = new int[26]; // lowercase english only
        for (char ch : word1.toCharArray())
            charCounts1[ch-'a'] += 1;
        
        int[] charCounts2 = new int[26]; // lowercase english only
        for (char ch : word2.toCharArray())
            charCounts2[ch-'a'] += 1;
        
        Map<Integer, Integer> countOccurrences = new HashMap();
        for (int i=0; i<26; i++) {
            if ((charCounts1[i] == 0 || charCounts2[i] == 0) && charCounts1[i] != charCounts2[i])
                return false;
            else {
                countOccurrences.compute(charCounts1[i], (k,v) -> (v==null) ? 1 : v+1 );
                countOccurrences.compute(charCounts2[i], (k,v) -> (v==null) ? -1 : v-1 );
            }
        }
        
        for (int x : countOccurrences.values())
            if (x != 0)
                return false;
        
        return true;
    }
}
