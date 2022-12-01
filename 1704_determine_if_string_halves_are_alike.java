// https://leetcode.com/problems/determine-if-string-halves-are-alike/
// Runtime: 4 ms, faster than 88.05%
// Memory Usage: 40.5 MB, less than 93.16%

class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int count = 0;

        int mid = s.length()/2;
        for (int i=0; i<mid; i++) {
            if (vowels.contains(s.charAt(i)))
                count++;
            if (vowels.contains(s.charAt(i+mid)))
                count--;
        }

        return count == 0;
    }
}
