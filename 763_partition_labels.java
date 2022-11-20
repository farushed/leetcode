// https://leetcode.com/problems/partition-labels/
// Runtime: 10 ms
// Memory Usage: 43.9 MB

class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lasts = new HashMap();
        for (int i=0; i<s.length(); i++) {
            lasts.put(s.charAt(i), i);
        }
        
        List<Integer> partSizes = new ArrayList();
     
        int curLast = 0;
        int start = 0;
        int i = start;
        while (curLast < s.length()) {
            for (; i<curLast+1; i++) {
                char c = s.charAt(i);
                curLast = Math.max(curLast, lasts.get(c));
            }
            partSizes.add(curLast-start+1);
            start = i;
            curLast++;
        }
        
        return partSizes;
    }
}
