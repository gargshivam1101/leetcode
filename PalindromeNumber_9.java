class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        // x1 = 123;
        // x2 = 121;
        int rev = 0;
        while (x > rev) {
            // rev = 3, x1 = 12 || rev = 1, x2 = 12
            // rev = 32, x1 = 1 || rev = 12, x2 = 1
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x == rev || x == rev/10);
    }
}
