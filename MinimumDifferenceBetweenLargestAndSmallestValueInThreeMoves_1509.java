class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;

        if (n <= 4) {
            return 0;
        }

        Arrays.sort(nums);

        int ans = Integer.MAX_VALUE;
        // explore all 4 possible cases and choose min as answer
        ans = Math.min(ans, nums[n - 4] - nums[0]); // remove 3 largest elements
        ans = Math.min(ans, nums[n - 3] - nums[1]); // remove 2 largest and 1 smallest elements
        ans = Math.min(ans, nums[n - 2] - nums[2]); // remove 1 largest and 2 smallest elements
        ans = Math.min(ans, nums[n - 1] - nums[3]); // remove 3 smallest elements
        return ans;
    }
}
