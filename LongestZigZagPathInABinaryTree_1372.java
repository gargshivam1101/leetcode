/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;

    private void helper(TreeNode node, boolean isLeft, int curr) {
        if (node == null) {
            return;
        }
        ans = Math.max(ans, curr);
        if (isLeft) {
            // if we have to go left
            // then either traverse left child and increase curr length
            // or start new path from right child
            helper(node.left, false, curr + 1);
            helper(node.right, true, 1);
        } else {
            // opposite
            helper(node.right, true, curr + 1);
            helper(node.left, false, 1);
        }
    }

    public int longestZigZag(TreeNode root) {
        helper(root, false, 0);
        helper(root, true, 0);
        return ans;
    }
}
