class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                if (buy == 0) {
                    // buy 0 means we need to buy
                    dp[i][0] = Math.max(-prices[i] + dp[i + 1][1], dp[i + 1][0]);
                } else {
                    // buy 1 means we need to sell
                    dp[i][1] = Math.max(prices[i] + dp[i + 2][0], dp[i + 1][1]);
                }
            }
        }
        return dp[0][0];
    }
}
