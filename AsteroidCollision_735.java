class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            while (!st.isEmpty() && a < 0 && st.peek() > 0) {
                // collision case
                int diff = a + st.peek();

                if (diff < 0) {
                    // left moving asteroid is alive, top of stack is destroyed
                    st.pop();
                } else if (diff > 0) {
                    // incoming asteroid destroyed, stack safe
                    a = 0;
                } else {
                    // both are destoryed
                    st.pop();
                    a = 0;
                }
            }
            // add to stack if no collision
            if (a != 0) {
                st.push(a);
            }
        }

        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}
