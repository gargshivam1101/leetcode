class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // intervals = [[1,2],[2,3],[3,4],[1,3]]
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        // intervals = [[1,2],[2,3],[1,3],[3,4]

        int end = intervals[0][1]; // 2
        int ans = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                ans++;
            }
        }
        return ans;
    }
}
