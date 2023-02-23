// https://leetcode.com/problems/ipo/
// Runtime 116 ms Beats 40.27%
// Memory 60.5 MB Beats 82.44%

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<int[]> byCapital = new ArrayList<>();
        for (int i=0; i<profits.length; i++)
            byCapital.add(new int[]{profits[i], capital[i]});
        Collections.sort(byCapital, (a,b)->(a[1]-b[1]));

        int i = 0;
        Queue<Integer> prof = new PriorityQueue<>();
        while (k-- > 0) {
            while (i<profits.length && w >= byCapital.get(i)[1])
                prof.offer(-byCapital.get(i++)[0]);
            if (prof.isEmpty())
                break;
            w += -prof.poll();
        }

        return w;
    }
}
