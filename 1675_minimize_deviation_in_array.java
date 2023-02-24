// https://leetcode.com/problems/minimize-deviation-in-array/
// Runtime 117 ms Beats 86.79%
// Memory 52.5 MB Beats 20.75%

class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int num : nums)
            s.add(num%2==0 ? num : num*2); // insert all even
        int result = s.last() - s.first();

        while (s.last() % 2 == 0) {
            s.add(s.pollLast() / 2);
            result = Math.min(result, s.last() - s.first());
        }

        return result;
    }
}
