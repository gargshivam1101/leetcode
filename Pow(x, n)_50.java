class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long tempN = n;

        if (tempN < 0) {
            // calculate as positive power first
            tempN *= -1;
        }

        while (tempN > 0) {
            if (tempN % 2 == 1) {
                ans *= x;
                tempN--;
            } else {
                x *= x;
                tempN /= 2;
            }
        }

        if (n < 0) {
            // at last, give answer as 1 / pow
            ans = (double) (1.0) / (double) (ans);
        }
        return ans;
    }
}
