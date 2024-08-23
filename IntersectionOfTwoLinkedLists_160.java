/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode nodeA = headA, nodeB = headB;

        // calculate lengths of both lists A and B
        while (nodeA != null || nodeB != null) {
            if (nodeA != null) {
                lenA++;
                nodeA = nodeA.next;
            }
            if (nodeB != null) {
                lenB++;
                nodeB = nodeB.next;
            }
        }

        int diff = lenA - lenB;

        if (diff < 0) {
            while(diff++ != 0) {
                headB = headB.next;
            }
        } else {
            while (diff-- != 0) {
                headA = headA.next;
            }
        }

        // now both heads are alligned
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
