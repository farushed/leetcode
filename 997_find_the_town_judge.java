// https://leetcode.com/problems/find-the-town-judge/
// Runtime 2 ms Beats 98.99%
// Memory 49.8 MB Beats 89.2%

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusted = new int[n+1];
        int[] trusts = new int[n+1];

        for (int[] t : trust) {
            trusts[t[0]] += 1;
            trusted[t[1]] += 1;
        }

        for (int i=1; i<=n; i++) {
            if (trusts[i] == 0 && trusted[i] == n-1)
                return i;
        }

        return -1;
    }
}
