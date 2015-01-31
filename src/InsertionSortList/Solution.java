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
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;

        ListNode current = head.next;
        head.next = null;
        ListNode node;
        ListNode prev;
        ListNode next;

        while(current != null) {
            next = current.next;
            prev = null;
            node = head;

            while(node != null && current.val > node.val) {
                if(prev == null)
                    prev = head;
                else
                    prev = node;

                node = node.next;
            }

            current.next = node;

            if(prev == null)
                head = current;
            else
                prev.next = current;

            current = next;
        }

        return head;
    }
}
