class Solution {
    private Boolean checkVowel(char c) {
        return c == 'a' || c == 'e' ||
                c == 'i' || c == 'o' ||
                c == 'u';
    }

    public int maxVowels(String s, int k) {
        int count = 0, ans = 0, l = 0, r = 0;

        while(r < s.length()) {
            if (checkVowel(s.charAt(r))) {
                count++;
            }
            k--;
            r++;
            if (k > 0) {
                continue;
            }
            if (ans < count) {
                ans = count;
            }
            if (checkVowel(s.charAt(l))) {
                count--;
            }
            l++;
        }
        return ans;
    }
}
