// https://leetcode.com/problems/concatenated-words/
// Runtime 76 ms Beats 58.30%
// Memory 44.8 MB Beats 99.12%

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordsSet = Set.of(words);

        List<String> result = new ArrayList<>();
        for (String word : words)
            if (check(word, wordsSet))
                result.add(word);

        return result;
    }

    boolean check(String word, Set<String> wordsSet) {
        return check(word, wordsSet, false);
    }

    boolean check(String word, Set<String> wordsSet, boolean allowSingleWord) {
        int len = word.length();
        if (allowSingleWord && wordsSet.contains(word))
            return true;

        for (int i=1; i<word.length(); i++) {
            if (wordsSet.contains(word.substring(0, i))
                    && check(word.substring(i, word.length()), wordsSet, true))
                return true;
        }

        return false;
    }
}
