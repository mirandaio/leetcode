/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode newHead = null;
        RandomListNode tail = null;
        HashMap<RandomListNode, RandomListNode> map =
            new HashMap<RandomListNode, RandomListNode>();

        while(head != null) {
            RandomListNode current;
            RandomListNode random;

            if(map.containsKey(head)) {
                current = map.get(head);
            } else {
                current = new RandomListNode(head.label);
                map.put(head, current);
            }

            if(tail == null) {
                newHead = current;
                tail = current;
            } else {
                tail.next = current;
                tail = current;
            }

            if(head.random != null) {
                if(map.containsKey(head.random)) {
                    random = map.get(head.random);
                } else {
                    random = new RandomListNode(head.random.label);
                    map.put(head.random, random);
                }

                tail.random = random;
            }

            head = head.next;
        }

        return newHead;
    }
}
