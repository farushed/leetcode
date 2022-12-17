// https://leetcode.com/problems/evaluate-reverse-polish-notation/
// Runtime 14 ms Beats 51.45%
// Memory 44.2 MB Beats 44.98%

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque();
        for (String tok : tokens) {
            int result;
            if (tok.equals("+")) {
                result = stk.pop() + stk.pop();
            } else if (tok.equals("-")) {
                result = -stk.pop() + stk.pop();
            } else if (tok.equals("*")) {
                result = stk.pop() * stk.pop();
            } else if (tok.equals("/")) {
                result = stk.pop();
                result = stk.pop() / result;
            } else {
                result = Integer.parseInt(tok);
            }
            stk.push(result);
        }

        return stk.pop();
    }
}
