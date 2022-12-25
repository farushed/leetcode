// https://leetcode.com/problems/longest-subsequence-with-limited-sum/
// Runtime 5 ms Beats 96.99%
// Memory 43.2 MB Beats 76.67%

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        for (int i=1; i<nums.length; i++) {
            nums[i] += nums[i-1]; // transform into prefix sum
        }

        int[] answer = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            answer[i] = binarySearchFloor(nums, queries[i]);
        }

        return answer;
    }

    int binarySearchFloor(int[] arr, int q) {
        int lo = 0, hi = arr.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (arr[mid] == q) return mid+1;
            if (arr[mid] < q)  lo = mid+1;
            else               hi = mid-1;
        }
        return lo;
    }
}
