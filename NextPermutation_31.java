class Solution {
    private void reverse(int[] nums, int left) {
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int idx = -1; // break point

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // idx has the break point, but if it is -1, then arr was descending
        // which means it is last, hence reverse to give smallest
        if (idx == -1) {
            reverse(nums, 0);
            return;
        }

        // in right part of arr, find next biggest from break point and swap
        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        // reverse the remaining right portion to find shortest among them
        reverse(nums, idx + 1);
    }
}
