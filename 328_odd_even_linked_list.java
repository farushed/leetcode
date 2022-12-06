// https://leetcode.com/problems/odd-even-linked-list/
// Runtime 0 ms Beats 100%
// Memory 42 MB Beats 82.86%

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;

        ListNode evenDummy = new ListNode();
        ListNode evenCur = evenDummy;
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            evenCur.next = cur.next;
            evenCur = evenCur.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }

        if (cur.next != null) {
            ListNode x = cur.next;
            evenCur.next = x;
            evenCur = x;
        }
        cur.next = evenDummy.next;
        evenCur.next = null;
        return head;
    }
}
