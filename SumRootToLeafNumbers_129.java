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

    private int helper(TreeNode root, int ans) {
        if (root == null) {
            return 0;
        }
        int curVal = ans * 10 + root.val;
        return root.left == null && root.right == null ? curVal : 
            helper(root.left, curVal) + helper(root.right, curVal);
    }

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
}
