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
    private void dfsHelper(TreeNode root, StringBuilder path, StringBuilder ans) {
        if (root == null) {
            return;
        }

        path.append((char) (root.val + 'a'));

        if (root.left == null && root.right == null) {
            // if it is leaf node, then check if current formed path is smallest
            String check = path.reverse().toString();
            if (ans.length() == 0 || check.compareTo(ans.toString()) < 0) {
                // if ans is not changed or bigger than current one
                ans.setLength(0);
                ans.append(check);
            }
            path.reverse();
        }

        dfsHelper(root.left, path, ans);
        dfsHelper(root.right, path, ans);

        // backtracking
        path.deleteCharAt(path.length() - 1);
    }


    public String smallestFromLeaf(TreeNode root) {
        StringBuilder ans = new StringBuilder(); // number of nodes are more than 0 so will be updated for sure
        dfsHelper(root, new StringBuilder(), ans);
        return ans.toString();
    }
}
