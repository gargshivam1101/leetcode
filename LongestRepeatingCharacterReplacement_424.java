class Solution {
    public int characterReplacement(String s, int k) {
        int [] count = new int[26];
        int ans = 0, maxCount = 0;
        int l = 0, r = 0;

        for (r = 0; r < s.length(); r++) {
            // count occurrence
            count[s.charAt(r) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(r) - 'A']);

            if (r - l + 1 - maxCount > k) {
                // incorrect, so move l forward
                count[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
