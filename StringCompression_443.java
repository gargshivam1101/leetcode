class Solution {
    public int compress(char[] chars) {
        int i = 0, idx = 0;
        while (i < chars.length) {
            int count = 1;
            while (i + count < chars.length && chars[i] == chars[i + count]) {
                // group
                count++;
            }
            chars[idx++] = chars[i];
            if (count > 1) {
                // append the count after the char
                for (char c: Integer.toString(count).toCharArray()) {
                    chars[idx++] = c;
                }
            }
            i += count;
        }
        return idx;
    }
}
