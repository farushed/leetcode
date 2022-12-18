// https://leetcode.com/problems/daily-temperatures/
// Runtime 28 ms Beats 87.4%
// Memory 60.1 MB Beats 79.15%

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Deque<Integer> waitingIndices = new ArrayDeque();

        for (int i=0; i<temperatures.length; i++) {
            int t = temperatures[i];
            while (!waitingIndices.isEmpty() && t > temperatures[waitingIndices.peek()]) {
                int j = waitingIndices.pop();
                answer[j] = i-j;
            }
            waitingIndices.push(i);
        }

        return answer;
    }
}
