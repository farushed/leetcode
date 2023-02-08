// https://leetcode.com/problems/jump-game-iii/
// Runtime 5 ms Beats 58.10%
// Memory 49.5 MB Beats 98.21%

class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (stack.size() > 0) {
            int i = stack.pop();
            if (arr[i] == 0)
                return true;

            int n = i + arr[i];
            if (n < arr.length && !visited[n]) {
                visited[n] = true;
                stack.push(n);
            }

            n = i - arr[i];
            if (n >= 0 && !visited[n]) {
                visited[n] = true;
                stack.push(n);
            }
        }

        return false;
    }
}
