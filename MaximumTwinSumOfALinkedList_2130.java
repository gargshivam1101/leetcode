/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reverseLL(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow has the middle now
        ListNode n1 = head;
        ListNode n2 = reverseLL(slow);

        int sum  = 0, ans = 0; // values of nodes begin from 1

        while (n2 != null) {
            sum = n1.val + n2.val;
            if (sum > ans) {
                ans = sum;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return ans;
    }
}
