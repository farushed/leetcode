// https://leetcode.com/problems/add-to-array-form-of-integer/
// Runtime 4 ms Beats 84.63%
// Memory 43.9 MB Beats 64.82%

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new LinkedList<>();

        int i = num.length-1;
        int carry = 0;
        while (i >= 0 || k != 0) {
            int s = (i>=0 ? num[i] : 0) + k%10 + carry;
            result.add(0, s % 10);
            carry = s / 10;
            k /= 10;
            i--;
        }
        if (carry == 1)
            result.add(0, 1);

        return result;
    }
}
