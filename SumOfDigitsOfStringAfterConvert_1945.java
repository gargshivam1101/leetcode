class Solution {
    public int getLucky(String s, int k) {
        int num = 0;

        for (char c : s.toCharArray()) {
            // done for k == 1
            int n = c - 'a' + 1;
            while (n > 0) {
                num += n % 10;
                n /= 10;
            }
        }

        while (k-- > 1) {
            int ans = 0;
            while (num > 0) {
                ans += num % 10;
                num /= 10;
            }
            num = ans;
        }

        return num;
    }
}
