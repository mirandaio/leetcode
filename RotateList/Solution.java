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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null)
            return null;

        ListNode node1 = head;
        ListNode node2 = head;
        ListNode rotated;

        while(n > 0) {
            if(node2.next == null)
                node2 = head;
            else
                node2 = node2.next;
            n--;
        }

        while(node2.next != null) {
            node2 = node2.next;
            node1 = node1.next;
        }

        node2.next = head;
        rotated = node1.next;
        node1.next = null;
        return rotated;
    }
}
