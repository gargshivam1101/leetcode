class Solution {
    public int minSteps(int n) {
        int ans = 0; // sum of all prime factors
        int d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}
