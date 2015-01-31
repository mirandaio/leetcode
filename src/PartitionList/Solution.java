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
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = null;
        ListNode smallerTail = null;
        ListNode greaterHead = null;
        ListNode greaterTail = null;
        ListNode next;

        while(head != null) {
            next = head.next;
            if(head.val < x) {
                if(smallerHead == null) {
                    smallerHead = head;
                    smallerTail = head;
                } else {
                    smallerTail.next = head;
                    smallerTail = head;
                }
                smallerTail.next = null;
            } else {
                if(greaterHead == null) {
                    greaterHead = head;
                    greaterTail = head;
                } else {
                    greaterTail.next = head;
                    greaterTail = head;
                }
                greaterTail.next = null;
            }

            head = next;
        }

        if(smallerHead == null)
            return greaterHead;

        smallerTail.next = greaterHead;

        return smallerHead;
    }
}
