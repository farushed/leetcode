// https://leetcode.com/problems/sort-characters-by-frequency/ 
// Runtime: 13 ms, faster than 93.48%
// Memory Usage: 43.3 MB, less than 86.86%

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        for (char ch : s.toCharArray())
            map.merge(ch, 1, (a,b)->a+b);

        return map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .map(e -> String.valueOf(e.getKey()).repeat(e.getValue()))
            .collect(Collectors.joining(""));
    }
}
