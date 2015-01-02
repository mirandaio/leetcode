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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null)
            return null;

        ListNode last = headA;
        ListNode slow = headB;
        ListNode fast = headB;

        while(last.next != null)
            last = last.next;

        last.next = headA;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                break;
        }

        if(fast == null || fast.next == null) {
            last.next = null;
            return null;
        }

        slow = headB;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        last.next = null;
        return slow;
    }
}
