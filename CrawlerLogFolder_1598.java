class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;

        for (String log: logs) {
            if (log.equals("./")) {
                // keep count same
            } else if (log.equals("../")) {
                ans = (ans == 0) ? 0 : ans - 1;
            } else {
                ans++;
            }
        }
        return ans;
    }
}
