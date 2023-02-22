// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
// Runtime 6 ms Beats 99.46%
// Memory 53.9 MB Beats 11.55%

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int totalWeight = 0;
        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            totalWeight += w;
        }

        int lo = Math.max(maxWeight, totalWeight/days);
        int hi = Math.min(totalWeight, totalWeight/days+maxWeight);
        while (lo < hi) {
            int mid = (lo+hi)/2;
            if (canShip(weights, days, mid))
                hi = mid;
            else
                lo = mid+1;
        }

        return lo;
    }

    boolean canShip(int[] weights, int days, int capacity) {
        int cur = 0;
        int curDays = 1;

        for (int w : weights) {
            cur += w;
            if (cur > capacity) {
                curDays++;
                if (curDays > days)
                    return false;
                cur = w;
            }
        }

        return true;
    }
}
