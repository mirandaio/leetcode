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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        head = sortList(head);
        second = sortList(second);
        ListNode newHead = null;
        ListNode tail = null;

        while(head != null && second != null) {
            if(head.val < second.val) {
                if(newHead == null)
                    newHead = head;
                else
                    tail.next = head;

                tail = head;
                head = head.next;
            } else {
                if(newHead == null)
                    newHead = second;
                else
                    tail.next = second;

                tail = second;
                second = second.next;
            }

            tail.next = null;
        }

        if(head != null)
            tail.next = head;

        if(second != null)
            tail.next = second;

        return newHead;
    }
}
