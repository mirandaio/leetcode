/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ahead = head;
        ListNode prev = head;

        while(n > 0) {
            ahead = ahead.next;
            n--;
        }

        if(ahead == null)
            return head.next;

        while(ahead.next != null) {
            prev = prev.next;
            ahead = ahead.next;
        }

        prev.next = prev.next.next;
        return head;
    }
}
