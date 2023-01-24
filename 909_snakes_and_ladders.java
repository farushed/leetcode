// https://leetcode.com/problems/snakes-and-ladders/
// Runtime 3 ms Beats 99.75%
// Memory 41.8 MB Beats 99.75%

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int nsq = n*n;

        boolean[] visited = new boolean[nsq+1];
        visited[1] = true;

        Queue<Integer> queue = new ArrayDeque();
        queue.offer(1);

        int moves = 0;
        while (!queue.isEmpty()) {
            moves++;
            int iters = queue.size();
            while (iters-- > 0) {
                int curr = queue.poll();

                for (int roll=1; roll<=6; roll++) {
                    int next = curr+roll;
                    int row = (nsq-next) / n;
                    int col = (next-1) % n;
                    if ((n-row & 1) == 0)
                        col = n-1 - col;
                    if (board[row][col] != -1)
                        next = board[row][col];

                    if (next == nsq)
                        return moves; // we got to the n^2 square in the least amount of moves

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        return -1; // couldn't get to n^2
    }
}
