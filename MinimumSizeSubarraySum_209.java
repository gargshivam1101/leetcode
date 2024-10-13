class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int currSum = 0, ans = 1000000;

        while (r < nums.length) {
            currSum += nums[r];

            while (currSum >= target) {
                ans = Math.min(ans, r - l + 1);
                currSum -= nums[l++];
            }
            r++;
        }
        return ans == 1000000 ? 0 : ans;
    }
}
