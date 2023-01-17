// https://leetcode.com/problems/flip-string-to-monotone-increasing/
// Runtime 8 ms Beats 96.61%
// Memory 42.8 MB Beats 84.41%

class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int[] prefixZeros = new int[len]; // includes current
        for (int i=0; i<len; i++)
            prefixZeros[i] = (i==0 ? 0 : prefixZeros[i-1]) + ('1'-s.charAt(i));

        int minFlips = prefixZeros[len-1]; // flip to all 1s

        for (int i=0 ; i<len; i++) {
            // flip:  1s at <= i to 0s,    others to 1s
            int cur = i+1-prefixZeros[i] + prefixZeros[len-1]-prefixZeros[i];
            minFlips = Math.min(minFlips, cur);
        }

        return minFlips;
    }
}
