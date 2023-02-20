// https://leetcode.com/problems/greatest-sum-divisible-by-three/
// Runtime 8 ms Beats 63.98%
// Memory 46.2 MB Beats 91.40%

class Solution {
    final int DIV = 3;
    public int maxSumDivThree(int[] nums) {
        int[] prev = new int[DIV];

        for (int num : nums) {
            int[] sumByResidue = new int[DIV];

            for (int i=0; i<DIV; i++) {
                int p = (i-num%DIV+DIV)%DIV; // in range [0,DIV)
                if (prev[p] != 0) {
                    sumByResidue[i] = prev[p] + num;
                } else if (p == 0) {
                    sumByResidue[i] = num;
                }
                sumByResidue[i] = Math.max(prev[i], sumByResidue[i]);
            }

            prev = sumByResidue;
        }

        return prev[0];
    }
}
