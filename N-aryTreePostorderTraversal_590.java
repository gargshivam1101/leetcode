/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }
        Stack<Node> st = new Stack<>();
        st.add(root);

        while (!st.isEmpty()) {
            Node curr = st.pop();
            ans.add(curr.val);

            for (Node child : curr.children) {
                st.add(child);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
