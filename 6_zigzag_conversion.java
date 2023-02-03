// https://leetcode.com/problems/zigzag-conversion/
// Runtime 3 ms Beats 95.40%
// Memory 42.2 MB Beats 95.48%

class Solution {
    public String convert(String s, int numRows) {
        int diagonal = Math.max(numRows - 2, 0);

        StringBuilder result = new StringBuilder();
        for (int row=0; row<numRows; row++) {
            for (int pos=row; pos<s.length(); pos+=numRows+diagonal) {
                result.append(s.charAt(pos));
                if (row!=0 && row!=numRows-1 && pos+(numRows-row-1)*2 < s.length()) {
                    result.append(s.charAt(pos+(numRows-row-1)*2));
                }
            }
        }

        return result.toString();
    }
}
