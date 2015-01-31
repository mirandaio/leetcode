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
        ListNode node = null;
        ListNode tail = null;
        ListNode tmp;
        int count;

        while(head != null) {
            tmp = head;
            count = 1;
            head = head.next;

            while(head != null && head.val == tmp.val) {
                head = head.next;
                count++;
            }

            if(count == 1) {
                if(node == null) {
                    node = tmp;
                    tail = tmp;
                } else {
                    tail.next = tmp;
                    tail = tmp;
                }
                tail.next = null;
            }
        }

        return node;
    }
}
