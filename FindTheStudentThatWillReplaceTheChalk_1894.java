class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int ch : chalk) {
            sum += ch;
        }
        k %= sum;

        for (int i = 0; i < chalk.length; i++) {
            k -= chalk[i];
            if (k < 0) {
                return i;
            }
        }
        return -1;
    }
}
