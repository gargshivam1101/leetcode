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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int splitVal = count / k, extra = count % k;
        temp = head;
        ListNode nextVal = head;

        ListNode[] ans = new ListNode[k];

        for (int i = 0; i < k; i++) {

            count = 0;
            ans[i] = nextVal;
            temp = nextVal;
            if (temp == null) {
                continue;
            }
            if (i < extra) {
                while (count < splitVal && temp != null) {
                    count++;
                    temp = temp.next;
                }
            } else {
                while (count < splitVal - 1 && temp != null) {
                    count++;
                    temp = temp.next;
                }
            }

            if (temp != null) {
                nextVal = temp.next;
                temp.next = null;
            } else {
                nextVal = null;
            }
        }
        return ans;
    }
}
