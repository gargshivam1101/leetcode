class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            // adding freq of each char of each word in corresponding array
            count1[word1.charAt(i) - 'a']++;
            count2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            // check if element is in 1st word, it should be in 2nd as well or vice versa
            if ((count1[i] != 0 && count2[i] == 0) || (count1[i] == 0 && count2[i] != 0)) {
                return false;
            }
        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        for (int i = 0; i < 26; i++) {
            // check if they can be swapped somehow
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}
