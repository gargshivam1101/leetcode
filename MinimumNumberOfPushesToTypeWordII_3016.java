class Solution {
    public int minimumPushes(String word) {

        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq, Collections.reverseOrder());

        int ans = 0;
        int i = 0;

        while (i < 26 && freq[i] != 0) {
            ans += freq[i] * ((i / 8) + 1);
            i++;
        }
        return ans;
    }
}
