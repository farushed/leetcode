// https://leetcode.com/problems/best-team-with-no-conflicts/
// Runtime 52 ms Beats 61.7%
// Memory 42 MB Beats 97.32%

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] sorted = new int[scores.length][];
        for (int i=0; i<scores.length; i++)
            sorted[i] = new int[] {scores[i], ages[i]};
        // sort by age and then by score
        Arrays.sort(sorted, (a,b) -> a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0]);

        int answer = 0;
        int[] dp = new int[scores.length];
        for (int i=0; i<dp.length; i++)
            dp[i] = sorted[i][0];

        for (int i=0; i<dp.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (sorted[i][0] >= sorted[j][0])
                    dp[i] = Math.max(dp[i], sorted[i][0] + dp[j]);
            }
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
