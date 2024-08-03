class Solution {
    public int uniquePaths(int m, int n) {
        int[] aboveRow = new int[n];

        for (int i = 0; i < m; i++) {
            int[] currRow = new int[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    currRow[j] = 1;
                    continue;
                }

                int up = 0, left = 0;
                if (i > 0) {
                    up = aboveRow[j];
                }
                if (j > 0) {
                    left = currRow[j - 1];
                }
                currRow[j] = up + left;
            }
            aboveRow = currRow;
        }
        return aboveRow[n - 1];
    }
}
