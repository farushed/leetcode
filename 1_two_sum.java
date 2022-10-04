// https://leetcode.com/problems/two-sum/
// Runtime: 3 ms, faster than 93.14% of Java online submissions for Two Sum.
// Memory Usage: 45.7 MB, less than 36.39% of Java online submissions for Two Sum.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            if (m.containsKey(nums[i])) {
                return new int[]{i, m.get(nums[i])};
            }
            m.put(target-nums[i], i);
        }

        return null;
    }
}
