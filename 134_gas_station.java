// https://leetcode.com/problems/gas-station/
// Runtime 1 ms Beats 100%
// Memory 62.1 MB Beats 91.71%

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int minTotal = Integer.MAX_VALUE;
        int minIdx = 0;

        for (int i=0; i<gas.length; i++) {
            total += gas[i] - cost[i];
            if (total <= minTotal) {
                minTotal = total;
                minIdx = i;
            }
        }

        if (total < 0)
            return -1;
        return (minIdx+1) % gas.length;
    }
}
