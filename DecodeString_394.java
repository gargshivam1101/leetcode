class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // build the count
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(count);
                count = 0;
                sbStack.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder toConcat = sb;
                sb = sbStack.pop();
                for (int i = countStack.pop() - 1; i >= 0; i--) {
                    sb.append(toConcat);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
