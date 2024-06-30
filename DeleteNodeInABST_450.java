/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            // search in left subtree
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // search in right subtree
            root.right = deleteNode(root.right, key);
        } else {
            // root is the node to be removed
            if (root.left == null && root.right == null) {
                // the only node, just remove it
                return null;
            } else if (root.left == null) {
                // the remaining subtree, which is right one, is returned
                return root.right;
            } else if (root.right == null) {
                // the remaining subtree, which is left one, is returned
                return root.left;
            } else {
                TreeNode curr = root.right; // left most child of right subtree
                while (curr.left != null) {
                    curr = curr.left;
                }
                // curr has the just greater value than root
                root.val = curr.val;
                // now root / key is no more
                // but curr is still in right subtree, so we need to remove it
                root.right = deleteNode(root.right, curr.val);
            }
        }
        return root;
    }
}
