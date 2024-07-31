class Solution {
    private int helper(int[] nums) {
        int first = 0, second = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int take = nums[i] + first;
            int notTake = second;
            first = second;
            second = Math.max(take, notTake);
        }
        return second;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length - 1)), 
                helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }
}
