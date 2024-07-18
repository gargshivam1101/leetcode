class Solution {
    public int climbStairs(int n) {
        // sum of n - 1 and n - 2
        // as we need only last two values, no need of dp array

        if (n == 0 || n == 1) {
            return 1;
        }

        int first = 1, second = 1, temp = 0;

        for (int i = 2; i <= n; i++) {
            temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }
}
