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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode n1 = null;
        ListNode n2 = null;
        ListNode current;
        ListNode next;

        for(int i = n - m + 2; i > 0; i--) {
            if(n2 == null)
                n2 = head;
            else
                n2 = n2.next;
        }

        for(int i = m - 1; i > 0; i--) {
            if(n1 == null)
                n1 = head;
            else
                n1 = n1.next;
            n2 = n2.next;
        }

        if(n1 == null)
            current = head;
        else
            current = n1.next;

        for(int i = n - m + 1; i > 0; i--) {
            next = current.next;
            current.next = n2;
            n2 = current;
            current = next;
        }

        if(n1 == null)
            head = n2;
        else
            n1.next = n2;

        return head;
    }
}
