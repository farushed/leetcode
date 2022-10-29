// https://leetcode.com/problems/reverse-linked-list/
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 42.2 MB, less than 83.20%

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode reversed = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;

            cur.next = reversed;
            reversed = cur;

            cur = tmp;
        }
        return reversed;
    }
}
