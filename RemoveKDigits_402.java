class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit: num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                // if bigger digit in stack then remove it
                stack.pop();
                k--;
            }
            // keep on pushing current digit
            stack.push(digit);
        }

        // If we still have k left, then remove from top
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // now stack has answer in reverse order, print that by removing leading 0s

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() > 0 ? sb.toString() : "0";
    }
}
