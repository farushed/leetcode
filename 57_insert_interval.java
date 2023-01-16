// https://leetcode.com/problems/insert-interval/
// Runtime 1 ms Beats 99.26%
// Memory 44.9 MB Beats 56.87%

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList();

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        int mergeStart = -1;
        boolean inserted = false;
        for (int[] interval : intervals) {
            if (inserted || interval[1] < newStart) { // before or already inserted: not affected
                result.add(interval);
                continue;
            }
            
            if (interval[0] <= newStart) { // intersect with start
                mergeStart = interval[0];
            } // ignore if interval fully inside new one

            // not chained as new interval may be contained inside other one
            if (interval[0] <= newEnd && newEnd <= interval[1]) {
                result.add(new int[] {mergeStart == -1 ? newStart : mergeStart, interval[1]});
                inserted = true;
            } else if (newEnd < interval[0]) { // overshot
                result.add(new int[] {mergeStart == -1 ? newStart : mergeStart, newEnd});
                result.add(interval);
                inserted = true;
            }
        }

        if (!inserted)
            result.add(new int[] {mergeStart == -1 ? newStart : mergeStart, newEnd});

        return result.toArray(new int[0][]);
    }
}
