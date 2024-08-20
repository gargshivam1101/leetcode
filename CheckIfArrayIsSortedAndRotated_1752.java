class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int issue = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                issue++;
            }
        }

        if (nums[0] < nums[n - 1]) {
            issue++;
        }

        return issue <= 1;
    }
}
