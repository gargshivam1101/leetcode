class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                int sec = st.pop();
                int fir = st.pop();
                st.push(fir + sec);
            } else if (s.equals("-")) {
                int sec = st.pop();
                int fir = st.pop();
                st.påçush(fir - sec);
            } else if (s.equals("*")) {
                int sec = st.pop();
                int fir = st.pop();
                st.push(fir * sec);
            } else if (s.equals("/")) {
                int sec = st.pop();
                int fir = st.pop();
                st.push(fir / sec);
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
