// https://leetcode.com/problems/naming-a-company/
// Runtime 349 ms Beats 65.57%
// Memory 57.7 MB Beats 42.62%

class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] suffixes = new Set[26];
        for (int i=0; i<26; i++)
            suffixes[i] = new HashSet<>();

        for (String idea : ideas)
            suffixes[idea.charAt(0)-'a'].add(idea.substring(1, idea.length()));

        long total = 0;
        for (int i=0; i<26; i++) {
            for (int j=i+1; j<26; j++) {
                Set<String> intersection = new HashSet<>(suffixes[i]);
                intersection.retainAll(suffixes[j]);

                total += 2 * (suffixes[i].size() - intersection.size())
                           * (suffixes[j].size() - intersection.size());
            }
        }

        return total;
    }
}
