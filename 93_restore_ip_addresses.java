// https://leetcode.com/problems/restore-ip-addresses/
// Runtime 2 ms Beats 93.10%
// Memory 42.4 MB Beats 79.22%

class Solution {
    public List<String> restoreIpAddresses(String s) {
        Set<String> result = new HashSet();
        StringBuilder cur = new StringBuilder();

        helper(s, 0, 0, cur, result);

        return new ArrayList(result);
    }

    void helper(String s, int idx, int dots, StringBuilder cur, Set<String> result) {
        if (dots == 3) {
            String rest = s.substring(idx, s.length());
            if (valid(rest)) {
                // cur contains three parts incl three dots, now need to add rest and store
                cur.append(rest);
                result.add(cur.toString());
                cur.delete(idx+dots, cur.length()+1);
            }
            return;
        }

        // recurse for each possible length
        for (int i=1; i<=3; i++) {
            if (idx+i > s.length())
                break;

            if (valid(s.substring(idx, idx+i))) {
                cur.append(s.substring(idx, idx+i));
                cur.append('.');
                helper(s, idx+i, dots+1, cur, result); // recurse
                cur.delete(idx+dots, cur.length()+1); // and backtrack
            }
        }
    }

    boolean valid(String s) {
        return (s.length() > 0
            && s.length() <= 3
            && !(s.length() > 1 && s.charAt(0) == '0') // no leading zeros
            && Integer.parseInt(s) <= 255); // check if in range
    }
}
