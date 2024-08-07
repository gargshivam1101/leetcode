public class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0, sum = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (freq.containsKey(sum - k)) {
                // this means that sum k exits between that index and this one
                ans += freq.get(sum - k);
            }
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
