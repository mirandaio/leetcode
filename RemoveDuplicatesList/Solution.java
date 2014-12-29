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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;

        ListNode n1 = head;
        ListNode n2 = head.next;
        n1.next = null;

        while(n2 != null) {
            if(n1.val != n2.val) {
                n1.next = n2;
                n1 = n2;
                n2 = n2.next;
                n1.next = null;
            } else {
                n2 = n2.next;
            }
        }

        return head;
    }
}
