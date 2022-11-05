// https://leetcode.com/problems/linked-list-cycle
// Runtime: 0 ms, faster than 100.00%
// Memory Usage: 43.3 MB, less than 93.54%

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

//     // Runtime: 0 ms, faster than 100.00%
//     // Memory Usage: 43.4 MB, less than 91.42%
//     public boolean hasCycle(ListNode head) {
//         ListNode prev;
//         while (head != null) {
//             if (head.next == head)
//                 return true; // head already cycled to itself, or we've visited it

//             prev = head;
//             head = head.next;

//             prev.next = prev; // cycle individual ones
//         }
//         return false;
//     }
}
