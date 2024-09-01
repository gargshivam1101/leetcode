class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            // 0th element is largest
            return 0;
        }

        if (nums[n - 1] > nums[n - 2]) {
            // last element is largest
            return n - 1;
        }

        // check between index 1 and n - 2
        int low = 1, high = n - 2, mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                // this is the answer
                return mid;
            } else if (nums[mid] < nums[mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
