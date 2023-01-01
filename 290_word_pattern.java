// https://leetcode.com/problems/word-pattern/
// Runtime 1 ms Beats 95.36%
// Memory 40 MB Beats 95.5%

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> words = new HashMap();

        String[] splitString = s.split(" ");
        if (pattern.length() != splitString.length)
            return false;

        int i = 0;
        for (String w : splitString) {
            char c = pattern.charAt(i++);
            if (words.containsKey(c)) {
                if (!words.get(c).equals(w))
                    return false; // char already bound to other word
            } else if (words.containsValue(w)) {
                return false; // word in s under second char
            } else {
                words.put(c, w);
            }
        }

        return true;
    }
}
