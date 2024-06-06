class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0, alt = 0; //altitude starts with 0
        for (int g: gain) {
            alt += g;
            if (alt > ans) {
                ans = alt;
            }
        }
        return ans;
    }
}
