class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ld = Integer.MAX_VALUE, rd = Integer.MAX_VALUE;
                int up = dp[i - 1][j];

                if (j - 1 >= 0) {
                    ld = dp[i - 1][j - 1];
                }

                if (j + 1 < n) {
                    rd = dp[i - 1][j + 1];
                }

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(ld, rd));
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }
}
