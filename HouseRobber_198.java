class Solution {
    public int rob(int[] nums) {
        int first = 0, second = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int take = nums[i] + first;
            int notTake = second;
            first = second;
            second = Math.max(take, notTake);
        }
        return second;
    }
}
