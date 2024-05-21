class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    private void helper(int begin, int k, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == k) {
            // current combination is complete
            ans.add(new ArrayList(curr));
            return;
        }

        int n = nums.length;
        for (int i = begin; i < n; i++) {
            curr.add(nums[i]);
            helper(i + 1, k, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        for (int k = 0; k < n + 1; k++) {
            // initialise curr list as empty one, first ans
            helper(0, k, new ArrayList<Integer>(), nums);
        }

        return ans;
    }
}
