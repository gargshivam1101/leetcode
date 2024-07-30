class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i; // update goal if we can reach them from current index
            }
        }
        return goal == 0; // if we reach the first index
    }
}
