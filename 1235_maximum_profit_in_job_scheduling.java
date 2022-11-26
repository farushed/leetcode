// https://leetcode.com/problems/maximum-profit-in-job-scheduling/
// Runtime: 33 ms, faster than 91.62%
// Memory Usage: 50.3 MB, less than 95.71%

class Solution {    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i=0; i<startTime.length; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> (a[1]-b[1]));
        
        // dp indices corresponding to jobs indices
        int[] dp = new int[jobs.length];
        dp[0] = jobs[0][2];
        
        // cur : [startTime, endTime, profit]
        for (int i=1; i<jobs.length; i++) {
            int[] cur = jobs[i];
            
            int k = Arrays.binarySearch(jobs, 0, i, new int[]{0, cur[0], 0}, (a, b) -> (a[1]-b[1]));
            if (k < 0)
                k = -k-1 - 1;
            else
                while (jobs[k+1][1] <= cur[0]) k++; // in case multiple equal keys
            
            dp[i] = Math.max(dp[i-1], ((k>=0) ? dp[k] : 0) + cur[2]);
        }
        // System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }
}
