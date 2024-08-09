class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0], second = cost[1];

        for (int i = 2; i <= n; i++) {
            int temp = Math.min(first, second);
            if (i < n) {
                temp += cost[i];
            }
            first = second;
            second = temp;
        }

        return second;
    }
}
