class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        boolean[] allowedChars = new boolean[26];

        for (int i = 0; i < allowed.length(); i++) {
            allowedChars[allowed.charAt(i) - 'a'] = true;
        }

        for (String word : words) {
            boolean isValid = true;

            for (int i = 0; i < word.length(); i++) {
                if (!allowedChars[word.charAt(i) - 'a']) {
                    // not in list of allowed chars, should not be part of answer
                    isValid = false;
                    break;
                }
            }
            ans += isValid ? 1 : 0;
        }
        return ans;
    }
}
