// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
// Runtime 31 ms Beats 91.65%
// Memory 59.8 MB Beats 71.48%

class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> m = new HashMap();

        for (int t : tasks)
            m.merge(t, 1, (a,b)->a+b);

        int total = 0;
        for (int num : m.values()) {
            if (num == 1) return -1;
            total += rounds(num);
        }

        return total;
    }

    public int rounds(int num) {
        if (num % 3 == 0)
            return num/3;
        return 1 + rounds(num-2);
    }
}
