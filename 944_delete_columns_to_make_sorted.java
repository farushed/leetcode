// https://leetcode.com/problems/delete-columns-to-make-sorted/
// Runtime 8 ms Beats 93.3%
// Memory 42.1 MB Beats 95.6%

class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;

        for (int col=0; col<strs[0].length(); col++) {
            char max = strs[0].charAt(col);

            for (int i=1; i<strs.length; i++) {
                if (strs[i].charAt(col) < max) {
                    count++;
                    break;
                }
                max = strs[i].charAt(col);
            }
        }

        return count;
    }
}
