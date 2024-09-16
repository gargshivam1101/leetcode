class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] minuteArr = new boolean[1440]; // 1440 minutes in a day

        for (String time : timePoints) {
            int minute = Integer.parseInt(time.substring(0, 2)) * 60 +
                    Integer.parseInt(time.substring(3));
            if (minuteArr[minute]) {
                // we already have same time available, then diff is 0
                return 0;
            }
            // otherwise, mark this one as true
            minuteArr[minute] = true;
        }
        int ans, prevTime, firstTime, lastTime;
        ans = prevTime = firstTime = lastTime = Integer.MAX_VALUE;

        for (int i = 0; i < 1440; i++) {
            if (!minuteArr[i]) {
                continue;
            }

            if (firstTime == Integer.MAX_VALUE) {
                // set the first time true is encountered
                firstTime = i;
            }
            lastTime = i;
            if (prevTime != Integer.MAX_VALUE) {
                // we need this condition to avoid the first case where i < prevTime
                ans = Math.min(ans, i - prevTime);
            }
            prevTime = i;
        }
        return Math.min(ans, 1440 + firstTime - lastTime);
    }
}
