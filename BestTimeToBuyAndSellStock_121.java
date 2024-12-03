class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], ans = 0;

        for (int price : prices) {
            if (price < buy) {
                buy = price;
            } else if (price - buy > ans) {
                ans = price - buy;
            }
        }
        return ans;
    }
}
