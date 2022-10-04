// https://leetcode.com/problems/container-with-most-water/submissions/
// Runtime: 3 ms, faster than 97.95% of Java online submissions for Container With Most Water.
// Memory Usage: 52.4 MB, less than 94.83% of Java online submissions for Container With Most Water.

class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        
        int max = 0;
        
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            if (area > max)
                max = area;
            
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        
        return max;
    }
}
