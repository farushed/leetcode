// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Runtime: 1 ms, faster than 79.75%
// Memory Usage: 42.5 MB, less than 31.81%

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;

        ListNode cur = start;
        ListNode ahead = start;
        for (int i=0; i<n; i++) {
            ahead = ahead.next;
        }

        while (ahead.next != null) {
            cur = cur.next;
            ahead = ahead.next;
        }

        cur.next = cur.next.next;

        return start.next;
    }
}
