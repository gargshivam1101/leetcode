class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+'; // mark this as visited

        int[] dirR = { 0, 1, 0, -1 };
        int[] dirC = { 1, 0, -1, 0 };
        int ans = 0;

        while (!q.isEmpty()) {
            ans++;
            for (int i = q.size(); i > 0; i--) {
                int[] pos = q.poll();

                for (int j = 0; j < 4; j++) {
                    int newR = pos[0] + dirR[j];
                    int newC = pos[1] + dirC[j];

                    if (newR >= 0 && newR < m && newC >= 0 && newC < n
                            && maze[newR][newC] != '+') {
                        if (newR == 0 || newR == m - 1 || newC == 0 || newC == n - 1) {
                            // it is boundary
                            return ans;
                        }
                        q.offer(new int[] { newR, newC });
                        maze[newR][newC] = '+';
                    }
                }
            }
        }
        return -1;
    }
}
