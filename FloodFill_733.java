class Solution {
    private void dfs(int[][] image, int i, int j, int color, int initColor, int[][] ans) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length ||
                image[i][j] != initColor || ans[i][j] == color) {
            return;
        }
        ans[i][j] = color;

        dfs(image, i + 1, j, color, initColor, ans);
        dfs(image, i - 1, j, color, initColor, ans);
        dfs(image, i, j + 1, color, initColor, ans);
        dfs(image, i, j - 1, color, initColor, ans);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = image[i][j];
            }
        }

        int initColor = image[sr][sc];

        dfs(image, sr, sc, color, initColor, ans);
        return ans;
    }
}
