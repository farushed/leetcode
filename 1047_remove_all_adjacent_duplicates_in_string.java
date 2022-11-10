// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/ 
// Runtime: 6 ms, faster than 98.27%
// Memory Usage: 49.7 MB, less than 65.59%

class Solution {
    public String removeDuplicates(String s) {
        char[] l = new char[s.length()+1];
        l[0] = '/';
        int i = 1;

        for (char c : s.toCharArray()) {
            if (c == l[i-1]) {
                i--;
            } else {
                l[i] = c;
                i++;
            }
        }

        return new String(l, 1, i-1);
    }
}
