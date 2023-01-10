// https://leetcode.com/problems/longest-palindromic-substring/
// Runtime 18 ms Beats 96.41%
// Memory 42.4 MB Beats 77%

class Solution {
    public String longestPalindrome(String s) {
        int maxi = 0;
        int maxj = 0;

        for (int i=0; i<s.length(); i++) {
            int len = expand(s, i, i);
            len = Math.max(len, expand(s, i, i+1));

            if (len > maxj-maxi) {
                maxi = i - (len-1)/2;
                maxj = i + len/2;
            }
        }

        return s.substring(maxi, maxj+1);
    }

    int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--; right++;
        }
        return right-left-1; // end on invalid combo
    }
}
