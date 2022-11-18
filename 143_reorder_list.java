// https://leetcode.com/problems/reorder-list/
// Runtime: 1 ms, faster than 100.00%
// Memory Usage: 45.3 MB, less than 83.85%

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
    public void reorderList(ListNode head) {
        // need to find middle first
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next; // first one in second half (not including middle if odd len)
        slow.next = null;

        // now reverse that second half
        ListNode prev = null;
        while (head2 != null) {
            ListNode tmp = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = tmp;
        }
        head2 = prev;

        // now interweave
        ListNode node = head;
        while (node != null) {
            ListNode tmp = node.next;
            if (head2 != null) {
                node.next = head2;
                head2 = head2.next;
                node.next.next = tmp;
            }
            node = tmp;
        }
    }
}
