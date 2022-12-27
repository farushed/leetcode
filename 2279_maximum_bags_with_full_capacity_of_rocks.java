// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
// Runtime 15 ms Beats 94.69%
// Memory 52.7 MB Beats 82.60%

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for (int i=0; i<rocks.length; i++) {
            rocks[i] = capacity[i] - rocks[i]; // how many more needed
        }
        Arrays.sort(rocks);

        int rocksUsed=0;
        for (int i=0; i<rocks.length; i++) {
            rocksUsed += rocks[i];
            if (rocksUsed > additionalRocks)
                return i;
        }

        return rocks.length;
    }
}
