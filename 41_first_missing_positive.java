// https://leetcode.com/problems/first-missing-positive
// Runtime: 2 ms, faster than 83.36%
// Memory Usage: 57.4 MB, less than 62.52%

class Solution {
    public int firstMissingPositive(int[] nums) {
        // i believe my solution is still O(n) as we go through each number and then
        // even though we jump around, as we set the next number(s) to 0 we do not redo anything
        // eg worst case we jump through every number in the first while loop
        // and then we iterate through the rest of the array again doing nothing because everything is 0
        int len = nums.length;

        // remove 0s from the array (by making them -1 which we also ignore)
        // so we can use 0 as a special value
        for (int i=0; i<len; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }

        int nPlus1 = 0;
        for (int i=0; i<len; i++) {
            int checkNext = nums[i];
            // we need to check the element before we "discard" it and also check what it points to (and so on)
            while (checkNext > 0 && checkNext <= len) {
                if (checkNext == len) {
                    nPlus1 = 1;
                    checkNext = 0;
                } else {
                    int tmp = nums[checkNext];
                    nums[checkNext] = 0; // signify that this number is present
                    checkNext = tmp;
                }
            }
        }

        // from idx 1 onwards, a 0 represents that number (idx) being present
        // so first nonzero number is our missing positive
        int i=1;
        while (i<len) {
            if (nums[i] != 0)
                return i;
            i++;
        }
        return i + nPlus1;
    }
}
