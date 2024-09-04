class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;

        while (a > 0 || b > 0 || c > 0) {
            int bitOfA = a & 1;
            int bitOfB = b & 1;
            int bitOfC = c & 1;

            if (bitOfC == 1) {
                // if any of A or B is 1, then we don't need any flip
                if (bitOfA == 0 && bitOfB == 0) {
                    // if both are 0, then flip any 1 of them
                    ans++;
                }
            } else {
                // we need to make sure both bits for A and B are 0
                ans += bitOfA + bitOfB;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return ans;
    }
}
