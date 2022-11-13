// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
// Runtime: 12 ms, faster than 82.17%
// Memory Usage: 97.3 MB, less than 23.89%

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        char last = ' '; // not a valid char to start with
        int totalTime = 0;
        int maxTime = 0;
        boolean multiple = false;

        int result = 0;

        for (int i=0; i<n; i++) {
            char c = colors.charAt(i);
            if (c == last) {
                totalTime += neededTime[i];
                maxTime = Math.max(maxTime, neededTime[i]);
                multiple = true;
            } else {
                if (multiple) {
                    result += totalTime - maxTime;
                }
                totalTime = neededTime[i];
                maxTime = neededTime[i];
                multiple = false;
            }
            last = c;
        }
        if (multiple) {
            result += totalTime - maxTime;
        }

        return result;
    }
}
