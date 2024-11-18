class Pair {
    int row;
    int col;
    int dist;

    Pair(int r, int c, int d) {
        this.row = r;
        this.col = c;
        this.dist = d;
    }
}

class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] visited = new int[m][n];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int[] dirR = { -1, 0, 1, 0 };
        int[] dirC = { 0, -1, 0, 1 };

        int[][] ans = new int[m][n];

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row, c = p.col, d = p.dist;

            ans[r][c] = d;

            for (int i = 0; i < 4; i++) {
                int newR = r + dirR[i];
                int newC = c + dirC[i];

                if (newR >= 0 && newR < m && newC >= 0 && newC < n &&
                        mat[newR][newC] == 1 && visited[newR][newC] != 1) {
                    q.add(new Pair(newR, newC, d + 1));
                    visited[newR][newC] = 1;
                }
            }
        }
        return ans;
    }
}
