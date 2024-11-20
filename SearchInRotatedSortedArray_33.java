class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid]) {
                // left part is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    // eliminate right
                    high = mid - 1;
                } else {
                    // eliminate left
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    // eliminate left
                    low = mid + 1;
                } else {
                    // eliminate right
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
