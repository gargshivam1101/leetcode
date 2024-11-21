class Solution {
    private int expand(int i, int j, String s) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        // window size is usually j - i + 1
        // but as i and j have moved already one extra left and right
        // we have to compensate it by -2
        return j - i - 1;
    }

    public String longestPalindrome(String s) {
        // i and j will have the centre indices
        // same for odd length palindrome, diff of 1 for even length

        int[] ans = new int[] { 0, 0 };

        for (int i = 0; i < s.length(); i++) {
            // odd case considering this index as centre of palindrome
            int oddCase = expand(i, i, s);
            if (oddCase > ans[1] - ans[0] + 1) {
                int dist = oddCase / 2;
                ans[0] = i - dist;
                ans[1] = i + dist;
            }

            // even case considering current and next index as the two centres
            int evenCase = expand(i, i + 1, s);
            if (evenCase > ans[1] - ans[0] + 1) {
                int dist = evenCase / 2 - 1;
                ans[0] = i - dist;
                ans[1] = i + dist + 1;
            }
        }
        return s.substring(ans[0], ans[1] + 1); // include jth index in ans
    }
}
