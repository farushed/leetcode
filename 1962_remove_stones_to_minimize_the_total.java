// https://leetcode.com/problems/remove-stones-to-minimize-the-total/
// Runtime 497 ms Beats 91.96%
// Memory 56.8 MB Beats 86.52%

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(piles.length, Comparator.reverseOrder());

        int total = 0;
        for (int p : piles) {
            maxHeap.offer(p);
            total += p;
        }
        
        for (int i=0; i<k; i++) {
            int p = maxHeap.poll();
            total -= p/2;
            maxHeap.offer(p-p/2);
        }

        return total;
    }
}
