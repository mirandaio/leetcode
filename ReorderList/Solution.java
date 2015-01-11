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
        ListNode current = head;
        head = null;
        ListNode tail = null;
        ListNode next;
        ListNode prev;
        ListNode last;

        while(current != null) {
            if(current.next == null) {
                if(tail != null)
                    tail.next = current;

                return;
            }

            next = current.next;
            prev = current;
            last = current.next;

            while(last.next != null) {
                prev = prev.next;
                last = last.next;
            }

            if(head == null) {
                head = current;
                tail = last;
                head.next = tail;
            } else {
                tail.next = current;
                current.next = last;
                tail = last;
            }

            prev.next = null;
            current = next;
        }
    }
}
