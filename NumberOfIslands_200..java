class Solution {

    private void dfsHelper(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            // out of bounds
            return;
        }

        if (grid[i][j] != '1') {
            return;
        }

        // mark this as visited
        grid[i][j] = '*';
        // mark all the neighbours also as visited as far as possible
        dfsHelper(grid, i + 1, j);
        dfsHelper(grid, i - 1, j);
        dfsHelper(grid, i, j + 1);
        dfsHelper(grid, i, j - 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfsHelper(grid, i, j);
                }
            }
        }
        return ans;
    }

}
