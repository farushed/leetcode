// https://leetcode.com/problems/subarray-sums-divisible-by-k/
// Runtime 5 ms Beats 86.51%
// Memory 45.8 MB Beats 94.64%

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] freqs = new int[k];
        freqs[0] = 1; // rest are 0

        int result = 0;
        int prefixSumModK = 0;
        for (int num : nums) {
            prefixSumModK = ((prefixSumModK + num)%k + k) % k; // add in num and ensure positive
            result += freqs[prefixSumModK]; // connect current to each of previous (could also sum n*(n-1)/2 at the end)
            freqs[prefixSumModK] += 1; // track that there is one more index with the given residue
        }

        return result;
    }
}
