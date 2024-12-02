class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE, sum = 0;

        for (int num : nums) {
            sum += num;
            ans = Math.max(ans, sum);
            sum = sum < 0 ? 0 : sum;
        }
        return ans;
    }
}
