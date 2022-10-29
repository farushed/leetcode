// https://leetcode.com/problems/reverse-linked-list-ii/
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 41.6 MB, less than 60.16%

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;
        int pos = 1;

        head = new ListNode(0, head);
        ListNode cur = head;
        while (pos < left) {
            cur = cur.next;
            pos++;
        }

        ListNode beforeReversed = cur; // at left-1
        cur = cur.next;
        ListNode prev = null;
        while (pos <= right) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            pos++;
        }
        beforeReversed.next.next = cur;
        beforeReversed.next = prev;
        return head.next;
    }
}
