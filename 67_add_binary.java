// https://leetcode.com/problems/add-binary/
// Runtime 1 ms Beats 100%
// Memory 40.8 MB Beats 94.5%

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            sum += (i >= 0) ? a.charAt(i--)-'0' : 0;
            sum += (j >= 0) ? b.charAt(j--)-'0' : 0;
            result.append(sum & 1);
            carry = (sum & 2) >> 1;
        }
        if (carry == 1)
            result.append(1);

        return result.reverse().toString();
    }
}
