class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0, skip = 1;

        while (r < nums.length) {
            if (nums[r] == 0) {
                skip--;
            }
            r++;
            if (skip < 0) {
                if (nums[l] == 0) {
                    skip++;
                }
                l++;
            }
        }
        return r - l - 1;
    }
}
