/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private int gcd(int n1, int n2) {
        while (n1 % n2 != 0) {
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        return n2;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            int n1 = temp.val;
            int n2 = temp.next.val;
            int gcd = gcd(n1, n2);

            ListNode newNode = new ListNode(gcd, temp.next);
            temp.next = newNode;
            temp = temp.next.next;
        }
        return head;
    }
}
