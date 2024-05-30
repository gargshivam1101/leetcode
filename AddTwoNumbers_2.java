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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode curr = ans;
        Boolean carry = false;

        while (l1 != null || l2 != null) {

            curr.val = (l1 != null ? l1.val : 0) +
                    (l2 != null ? l2.val : 0) +
                    (carry ? 1 : 0);
            if (curr.val > 9) {
                carry = true;
                curr.val %= 10;
            } else {
                carry = false;
            }

            if (!carry &&
                    (l1 == null || l1.next == null) &&
                    (l2 == null || l2.next == null)) {
                break;
            }
            curr.next = new ListNode();
            curr = curr.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        if (carry) {
            curr.val = 1;
        }
        return ans;
    }
}
