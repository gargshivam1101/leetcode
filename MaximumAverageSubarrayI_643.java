class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = -Double.MAX_VALUE, sum = 0;
        int l = 0, r = 0;
        
        while (r < nums.length) {
            sum += nums[r];
            r++;
            if (r < k) {
                continue;
            }
            ans = Math.max(sum / k, ans);
            sum -= nums[l];
            l++;
        }
        return ans;
    }
}
