// https://leetcode.com/problems/decode-ways/
// Runtime: 1 ms, faster than 98.36%
// Memory Usage: 40.7 MB, less than 88.72%

class Solution {
    public int numDecodings(String s) {
        char[] cs = s.toCharArray();

        int[] dp = new int[cs.length+1];
        dp[cs.length] = 1;
        dp[cs.length-1] = cs[cs.length-1] == '0' ? 0 : 1;
        for (int i=cs.length-2; i>=0; i--) {
            int a = cs[i] - '0';
            int b = cs[i+1] - '0';

            if (a != 0) {
                dp[i] = dp[i+1];
                if (a == 1 || (a == 2 && b <= 6)) {
                    dp[i] += dp[i+2];
                }
            }
        }

        return dp[0];
    }
}
