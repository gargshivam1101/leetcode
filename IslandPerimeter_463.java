class Solution {
    public int islandPerimeter(int[][] grid) {
        // if the cell is 1, add 4 for all for sides
        // check if the top cell, or the left cell is also 1, then deduct 2 from ans
        int ans = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    ans += 4;

                    if (r > 0 && grid[r - 1][c] == 1) {
                        // check above
                        ans -= 2;
                    }
                    if (c > 0 && grid[r][c - 1] == 1) {
                        // check left
                        ans -= 2;
                    }
                }
            }
        }
        return ans;
    }
}
