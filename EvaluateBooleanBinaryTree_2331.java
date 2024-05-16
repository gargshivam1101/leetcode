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
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            // leaf node, check if it is 0 then true, otherwise false
            return root.val == 1;
        }
        // non leaf node
        boolean leftTree = evaluateTree(root.left);
        boolean rightTree = evaluateTree(root.right);
        return root.val == 2 ? leftTree || rightTree : leftTree && rightTree;
    }
}
