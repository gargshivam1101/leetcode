class Solution {

    private void helper(List<String> ans, int left, int right, String temp, int n) {
        if (left == n && right == n) {
            ans.add(temp);
            return;
        }

        if (left < n) {
            helper(ans, left + 1, right, temp + "(", n);
        }

        if (right < left) {
            helper(ans, left, right + 1, temp + ")", n);
        }
    }

    public List<String> generateParenthesis(int n) {
        /**
        Open parenthesis count should be < n
        Closed should be less than open
        Stop when open = closed = n
        */
        List<String> ans = new ArrayList<>();
        helper(ans, 0, 0, "", n);
        return ans;
    }
}Generate Parentheses
