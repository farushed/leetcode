// https://leetcode.com/problems/sum-of-subarray-minimums/
// Runtime: 15 ms, faster than 99.27%
// Memory Usage: 49.8 MB, less than 89.50%

class Solution {
    // start at each element, go through rest of array, and add running min to total each time
    // but do all in one pass
    //
    // each starting point has corresponding number in stack, which is only changed when lower num is come across
    // and the 'length' grows by one each iteration as we start new running mins
    // in stack we store a running min, and how many running mins it represents
    //
    // also keep the sum of the mins in the current "vertical slice" and update it together with stack,
    // instead of recalculating stack sum each iteration (very big improvement)
    public int sumSubarrayMins(int[] arr) {
        Deque<int[]> stack = new ArrayDeque();

        int total = 0;
        int val = 0;
        for (int i=0; i<arr.length; i++) {
            int n = 0;
            while (stack.size() > 0 && arr[i] < stack.peek()[0]) {
                int[] x = stack.pop();
                val -= x[0]*x[1];
                n += x[1];
            }

            stack.push(new int[] {arr[i], n+1});
            val += arr[i] * (n+1);

            total += val;

            total %= 1_000_000_007;
        }

        return total;
    }
}
