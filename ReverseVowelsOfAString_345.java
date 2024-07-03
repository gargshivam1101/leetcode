class Solution {

    private boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private void swap(char[] str, int l, int r) {
        char temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }

    public String reverseVowels(String s) {
        int l = 0, r = s.length() - 1;

        char[] str = s.toCharArray();

        while (l < r) {
            while (l < r && !isVowel(str[l])) {
                l++;
            }

            while (l < r && !isVowel(str[r])) {
                r--;
            }

            swap(str, l, r);
            l++;
            r--;
        }
        return new String(str);
    }
}
