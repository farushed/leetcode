// https://leetcode.com/problems/swap-nodes-in-pairs/
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 39.7 MB, less than 95.39%

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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0, head);
        ListNode node = dummy;
        while (node.next != null) {
            ListNode nn = node.next.next;
            if (nn == null) break;
            node.next.next = nn.next;
            nn.next = node.next;
            node.next = nn;

            node = node.next.next;
        }

        return dummy.next;
    }
}
