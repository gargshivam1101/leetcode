class Solution {
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;

        // 1,2,3,4,5,6,7
        reverse(nums, 0, nums.length - 1); // 7,6,5,4,3,2,1
        reverse(nums, 0, k - 1); // 5,6,7,4,3,2,1
        reverse(nums, k, nums.length - 1); // 5,6,7,1,2,3,4
    }
}
