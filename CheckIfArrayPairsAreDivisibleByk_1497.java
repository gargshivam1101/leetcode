class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];

        for (int a : arr) {
            freq[((a % k) + k) % k]++;
        }

        // check for 0 case
        if (freq[0] % 2 != 0) {
            return false;
        }

        for (int i = 1; i < k / 2 + 1; i++) {
            // beginning and end should be equal
            if (freq[i] != freq[k - i]) {
                return false;
            }
        }
        return true;
    }
}
