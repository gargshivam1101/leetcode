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
    public ListNode modifiedList(int[] nums, ListNode head) {
        /**
         * Searching in Array takes O(1) space, but O(n) time
         * If our priority is time complexity, then it is better to use HashSet
         * Searching in HashSet takes O(n) space, bu provides O(1) time
         */

        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());

        // dummy node
        ListNode newN = new ListNode(0, head);
        ListNode temp = newN;

        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return newN.next;
    }
}
