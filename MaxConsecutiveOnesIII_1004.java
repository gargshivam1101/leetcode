class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, flip = 0;

        while (r < nums.length) {
            if (nums[r] == 0) {
                flip++;
            }
            r++; // in any case, 0 or 1

            if (flip > k) {
                if (nums[l] == 0) {
                    flip--;
                }
                l++;
            }
        }
        return r - l;
    }
}
