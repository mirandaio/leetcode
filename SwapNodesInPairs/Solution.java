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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode second = head.next;
        ListNode node = null;
        ListNode tail = null;
        ListNode next;

        while(second != null) {
            next = second.next;

            if(node == null) {
                node = second;
                node.next = first;
                tail = first;
            } else {
                tail.next = second;
                tail.next.next = first;
                tail = first;
            }

            tail.next = null;
            first = next;

            if(first == null)
                break;

            second = first.next;

            if(second == null)
                tail.next = first;
        }

        return node;
    }
}
