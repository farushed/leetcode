// https://leetcode.com/problems/single-threaded-cpu/
// Runtime 207 ms Beats 67.97%
// Memory 99 MB Beats 73.96%

class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] answer = new int[tasks.length];
        int answerIndex = 0;

        // sort by start time
        Integer[] sortedIndices = new Integer[tasks.length];
        for (int i=0; i<tasks.length; i++)
            sortedIndices[i] = i;
        Arrays.sort(sortedIndices, (a, b) -> Integer.compare(tasks[a][0], tasks[b][0]));

        // sort by processing time, and then by index
        Queue<Integer> heap = new PriorityQueue(
            (a, b) -> (tasks[(int) a][1] != tasks[(int) b][1])
                ? (tasks[(int) a][1] - tasks[(int) b][1])
                : ((int) a - (int) b) );

        int time = tasks[sortedIndices[0]][0];
        int sortedIndex = 0;

        // add available tasks
        while (sortedIndex < tasks.length && tasks[sortedIndices[sortedIndex]][0] <= time) {
            heap.offer(sortedIndices[sortedIndex]);
            sortedIndex++;
        }

        while (!heap.isEmpty()) {
            int taskIndex = heap.poll();
            answer[answerIndex++] = taskIndex;

            // advance time by processing or to next task (if no more currently available)
            time += tasks[taskIndex][1];
            if (heap.isEmpty() && sortedIndex < tasks.length && tasks[sortedIndices[sortedIndex]][0] > time)
                time = tasks[sortedIndices[sortedIndex]][0];

            // add available tasks
            while (sortedIndex < tasks.length && tasks[sortedIndices[sortedIndex]][0] <= time) {
                heap.offer(sortedIndices[sortedIndex]);
                sortedIndex++;
            }
        }

        return answer;
    }
}
