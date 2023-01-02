// https://leetcode.com/problems/detect-capital/
// Runtime 1 ms Beats 100%
// Memory 40.6 MB Beats 90.66%

class Solution {
    public boolean detectCapitalUse(String word) {
        boolean firstUpper = ((word.charAt(0) & 0x20) == 0);
        boolean allUpper = true;
        boolean allLower = true;

        for (int i=1; i<word.length(); i++) {
            char c = word.charAt(i);
            allUpper = allUpper && ((c & 0x20) == 0);
            allLower = allLower && ((c & 0x20) != 0);
        }

        return (firstUpper && allUpper) || allLower; // first char doesnt matter if all the rest are lower
    }
}
