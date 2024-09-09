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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int row = 0, col = 0, currDir = 0;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // right, down, left, up

        int[][] ans = new int[m][n];

        // As node.val can be 0 also, so we cannot keep the values of ans as default 0s,
        // and have to change them to something negative

        for (int[] r : ans) {
            Arrays.fill(r, -1);
        }

        while (head != null) {
            ans[row][col] = head.val;
            int nextRow = row + dir[currDir][0];
            int nextCol = col + dir[currDir][1];

            // we need to move our direction if out of bounds, or visited cell
            if (nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n ||
                    ans[nextRow][nextCol] != -1) {
                currDir = (currDir + 1) % 4;
            }

            row += dir[currDir][0];
            col += dir[currDir][1];
            head = head.next;
        }
        return ans;
    }
}
