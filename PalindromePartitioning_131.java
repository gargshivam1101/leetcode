class Solution {

    private boolean isPalindrome(String s, int left, int right) {
        // Check if the substring s[left:right+1] is a palindrome
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    private void backtrack(String s, int begin, List<String> path, List<List<String>> ans) {
        if (begin == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int end = begin + 1; end <= s.length(); end++) {
            if (isPalindrome(s, begin, end - 1)) {
                path.add(s.substring(begin, end));
                backtrack(s, end, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }
}
