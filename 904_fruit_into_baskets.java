// https://leetcode.com/problems/fruit-into-baskets/
// Runtime 6 ms Beats 96.39%
// Memory 51.6 MB Beats 61.70%

class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0;

        int start = 0;
        int end = 1;

        int fruit1 = fruits[0];
        int fruit2 = -1;
        int count1 = 1;
        int count2 = -1;

        while (end < fruits.length) {
            if (fruits[end] == fruit1) {
                count1++;
            } else if (fruits[end] == fruit2) {
                count2++;
            } else if (fruit2 == -1) {
                fruit2 = fruits[end];
                count2 = 1;
            } else {
                max = Math.max(max, end-start);
                int last = fruits[end-1]; // one of fruit1 or fruit2
                if (last == fruit2) {
                    int tmp = count2;
                    count2 = count1;
                    count1 = tmp;
                    fruit2 = fruit1;
                    fruit1 = last;
                } // now fruit1 is the one we keep, get rid of fruit2s
                while (count2 > 0 && start<fruits.length) {
                    if (fruits[start] == fruit2)
                        count2--;
                    else
                        count1--;
                    start++;
                }
                fruit2 = fruits[end];
                count2 = 1;
            }
            end++;
        }

        return Math.max(max, end-start);
    }
}
