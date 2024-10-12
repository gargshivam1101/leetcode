class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            // no need to loop for positive values, as other i's have to offset them for 0

            if (i != 0 && nums[i] == nums[i - 1]) {
                // no need for duplicates
                continue;
            }

            // solve two sum now
            int target = -nums[i], l = i + 1, r = nums.length - 1;

            while (l < r) {
                if (nums[l] + nums[r] < target) {
                    l++;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    // match found
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    while (l < r && nums[r] == nums[r + 1]) {
                        // no need for duplicates
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
