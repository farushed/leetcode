// https://leetcode.com/problems/longest-increasing-subsequence/
// Runtime: 5 ms, faster than 94.80%
// Memory Usage: 41.9 MB, less than 88.71%

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> l = new ArrayList<>();
        l.add(nums[0]);

        for (int num : nums) {
            int last = l.get(l.size()-1);
            if (num > last)
                l.add(num);
            else
                l.set(binarySearch(l, num), num);
        }

        return l.size();
    }

    public int binarySearch(List<Integer> l, int target) {
        int i = 0;
        int j = l.size()-1;
        int m=0;

        while (i < j) {
            m = (i+j)/2;
            if (l.get(m) == target)
                return m;
            else if (l.get(m) > target)
                j = m;
            else
                i = m+1;
        }

        if (l.get(m) < target)
            return m+1;
        else
            return m;
    }

}
