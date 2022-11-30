// https://leetcode.com/problems/unique-number-of-occurrences/
// Runtime: 4 ms, faster than 67.11%
// Memory Usage: 41.7 MB, less than 74.79%

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap();
        for (int n : arr)
            occurrences.compute(n, (k,v) -> (v==null) ? 1 : v+1);

        return (new HashSet(occurrences.values())).size() == occurrences.size();
    }
}
