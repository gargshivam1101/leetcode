class Solution {
    public int longestPalindrome(String s) {
        int odd = 0;
        int[] freq = new int[52];

        for (char c : s.toCharArray()) {
            int cnt = 0;
            if (Character.isUpperCase(c)) {
                cnt = ++freq[c - 'A'];
            } else {
                cnt = ++freq[c - 'a' + 26];
            }

            if (cnt % 2 == 0) {
                odd--;
            } else {
                odd++;
            }
        }

        return odd > 0 ? s.length() - odd + 1 : s.length();
    }
}
