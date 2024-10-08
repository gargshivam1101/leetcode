class Solution {
        private int longestPalindromeSubseq(String s) {
        String revS = new StringBuilder(s).reverse().toString();

        // find LCS of s and revS
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == revS.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
}
