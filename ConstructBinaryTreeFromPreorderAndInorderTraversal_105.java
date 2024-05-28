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
    int preIdx;

    private TreeNode helper(int[] preorder, Map<Integer, Integer> map, int i, int j) {
        if (i > j) {
            return null;
        }

        // root node of the subtree is the first one of the remaining preorder
        TreeNode root = new TreeNode(preorder[preIdx]);
        preIdx++;

        int rootIdx = map.get(root.val);

        // elements inorder, before this index should be in left subtree, and after in right subtree
        root.left = helper(preorder, map, i, rootIdx - 1);
        root.right = helper(preorder, map, rootIdx + 1, j);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
         * Preorder = root -> left -> right
         * Inorder = left -> root -> right
         */

        // map to store indices of inorder traversal
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        preIdx = 0;
        return helper(preorder, map, 0, inorder.length - 1);
    }
}
