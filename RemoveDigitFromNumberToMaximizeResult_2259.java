class Solution {
    public String removeDigit(String number, char digit) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) == digit && number.charAt(i + 1) > digit) {
                return new StringBuilder(number).deleteCharAt(i).toString();
            }
        }
        return new StringBuilder(number).deleteCharAt(
            number.lastIndexOf(digit)).toString();
    }
}
