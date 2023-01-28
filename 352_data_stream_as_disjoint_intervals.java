// https://leetcode.com/problems/data-stream-as-disjoint-intervals/
// Runtime 64 ms Beats 70.59%
// Memory 47.3 MB Beats 81.9%

class SummaryRanges {
    TreeMap<Integer, Integer> intervals; // store start: end


    public SummaryRanges() {
        intervals = new TreeMap<>();
    }
    
    public void addNum(int value) {
        Integer f = intervals.floorKey(value);
        Integer c = intervals.ceilingKey(value);
        if (f != null && c != null) {
            boolean added = false;
            boolean mergedDown = false;
            if (value <= intervals.get(f)+1) {
                intervals.put(f, Math.max(value, intervals.get(f)));
                mergedDown = true;
                added = true;
            }
            if (value == c-1) {
                intervals.put(mergedDown ? f : value, intervals.get(c));
                intervals.remove(c);
                added = true;
            }
            if (!added) {
                intervals.put(value, value);
            }
        } else if (c != null) {
            if (value == c-1) {
                intervals.put(value, intervals.get(c));
                intervals.remove(c);
            } else if (value < c-1) {
                intervals.put(value, value);
            }
        } else if (f != null) {
            if (value <= intervals.get(f)+1) {
                intervals.put(f, Math.max(value, intervals.get(f)));
            } else {
                intervals.put(value, value);
            }
        } else { // f == null && c == null
            intervals.put(value, value);
        }
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[intervals.size()][2];
        int i=0;
        for (int start : intervals.keySet())
            res[i++] = new int[] {start, intervals.get(start)};
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
