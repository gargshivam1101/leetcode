class Solution {
    public boolean canPartition(int[] nums) {
        // check if we are able to find any one subset with sum = totalSum / 2
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 == 1) {
            // if it is odd, we can never partition
            return false;
        }

        // now we need to check subset sum equal to totalSum / 2
        totalSum /= 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n][totalSum + 1];

        for (int i = 0; i < n; i++) {
            // we can always return true if totalSum = 0
            dp[i][0] = true;
        }

        if (nums[0] <= totalSum) {
            // we can reach
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < totalSum + 1; j++) {
                boolean notTake = dp[i - 1][j];

                boolean take = false;
                if (nums[i] <= j) {
                    take = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = notTake || take;
            }
        }
        return dp[n - 1][totalSum];
    }
}
