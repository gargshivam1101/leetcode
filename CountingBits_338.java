class Solution {
    public int[] countBits(int n) {
        /**
         * if x /2 = y, then:
         * when x is odd, then no of set bits in x = 1 + no of set bits in y
         * when x is even, then no of set bits in x = no of set bits in y
         */
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i % 2 + dp[i / 2]; // i % 2 adds 1 if odd, otherwise 0
        }
        return dp;
    }
}
