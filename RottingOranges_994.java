class Pair {
    int row;
    int col;
    int time;

    Pair(int r, int c, int t) {
        this.row = r;
        this.col = c;
        this.time = t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];
        Queue<Pair> q = new LinkedList<>();

        int totalFreshCount = 0, visitedFreshCount = 0, ans = 0;

        // initialize and find starting points
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else if (grid[i][j] == 1) {
                    totalFreshCount++;
                }
            }
        }
        
        // four directions to check
        int[] dirR = { -1, 0, 1, 0 };
        int[] dirC = { 0, -1, 0, 1 };

        // perform BFS
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row, c = p.col, t = p.time;
            ans = Math.max(ans, t);

            for (int i = 0; i < 4; i++) {
                int newR = r + dirR[i];
                int newC = c + dirC[i];

                if (newR >= 0 && newR < m && newC >= 0 && newC < n &&
                        grid[newR][newC] == 1 && visited[newR][newC] != 2) {
                    q.add(new Pair(newR, newC, t + 1));
                    visited[newR][newC] = 2;
                    visitedFreshCount++;
                }
            }
        }

        return totalFreshCount == visitedFreshCount ? ans : -1;
    }
}
