class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            while (i < intervals.length - 1 && intervals[i + 1][0] <= end) {
                end = Math.max(end, intervals[++i][1]);
            }
            ans.add(new int[] { start, end });
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
