class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // using prefix sum, time complexity goes to n^2
        // use prefix mod

        int prefixMod = 0, ans = 0;
        int [] mods = new int[k]; // number of times the index was the remainder
        mods[0] = 1; // to handle case where sum is divisble by k

        for (int num: nums) {
            // extra +k is done to handle case of negative numbers
            prefixMod = (prefixMod + num % k + k) % k;
            ans += mods[prefixMod];
            mods[prefixMod]++;
        }
        return ans;
    }
}
