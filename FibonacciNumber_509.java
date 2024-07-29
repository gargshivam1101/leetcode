class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int first = 0, second = 1, ans = 1;

        for (int i = 1; i < n; i++) {
            ans = first + second;
            first = second;
            second = ans;
        }
        return ans;
    }
}
