class Solution {
    public String convert(String s, int numRows) {
        char[] charArr = s.toCharArray();

        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }

        for (int i = 0; i < charArr.length;) {
            for (int idx = 0; idx < numRows && i < charArr.length; idx++) {
                // first go downwards in the same column
                sb[idx].append(charArr[i++]);
            }
            for (int idx = numRows - 2; idx > 0 && i < charArr.length; idx--) {
                // go diagnoly upwards from second last row until the second row
                sb[idx].append(charArr[i++]);
            }
        }

        for (int i = 1; i < sb.length; i++) {
            // merge all row strings
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
