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
    public void reorderList(ListNode head) {
        if(head == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p2 = slow.next;
        slow.next = null;
        ListNode p1 = head;
        p2 = reverse(p2);
        ListNode next1;
        ListNode next2;

        while(p2 != null) {
            next1 = p1.next;
            next2 = p2.next;
            p1.next = p2;
            p2.next = next1;
            p1 = next1;
            p2 = next2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode node = null;
        ListNode next;

        while(head != null) {
            next = head.next;
            head.next = node;
            node = head;
            head = next;
        }

        return node;
    }
}
