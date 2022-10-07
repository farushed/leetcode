// https://leetcode.com/problems/3sum/
// Runtime: 32 ms, fsater than 69.68%
// Memory Usage: 59 MB, less than 56.13%

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // so duplicates are in the same order and we can eliminate higher or lower elements based on sum > or < 0

        List<List<Integer>> result = new LinkedList<>();

        int l = nums.length;
        int a, b, c, j, k, sum;
        for (int i=0; i<l; i++) {
            if (i==0 || nums[i] != nums[i-1]) {
                a = nums[i];

                j = i+1;
                k = l-1;

                while (j < k) {
                    b = nums[j];
                    c = nums[k];

                    sum = a + b + c;
                    if (sum == 0) {
                        result.add(List.of(a, b, c));
                        while (j < k && nums[j]==b) j += 1;
                        while (j < k && nums[k]==c) k -= 1;
                    } else if (sum > 0) {
                        k -= 1;
                    } else {
                        j += 1;
                    }

                }
            }
        }

        return result;
    }
}
