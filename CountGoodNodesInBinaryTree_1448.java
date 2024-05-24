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

    private int helper(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        Boolean good = false;
        if (root.val >= max) {
            max = root.val;
            good = true;
        }
        return (good ? 1 : 0) + helper(root.left, max) + helper(root.right, max);
    }

    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        return helper(root, max);
    }
}
