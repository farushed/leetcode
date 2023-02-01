// https://leetcode.com/problems/greatest-common-divisor-of-strings/
// Runtime 2 ms Beats 35.56%
// Memory 42.2 MB Beats 68.76%

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int shorter = Math.min(str1.length(), str2.length());
        for (int i=shorter; i>0; i--) {
            String sub = str1.substring(0, i);
            if (divides(sub, str1) && divides(sub, str2))
                return sub;
        }
        return "";
    }

    // check if string 0 to i (inclusive) divides str
    boolean divides(String sub, String str) {
        if (str.length() % sub.length() != 0)
            return false;

        for (int j=0; j<str.length(); j+=sub.length())
            if (!str.substring(j, j+sub.length()).equals(sub))
                return false;

        return true;
    }
}
