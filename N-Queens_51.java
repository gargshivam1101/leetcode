class Solution {
    private void solve(int col, char[][] board, List<List<String>> ans, int leftRow[], int lowerDiagonal[],
            int upperDiagonal[]) {
        if (col == board.length) {
            List<String> oneAns = new LinkedList<String>();
            for (int i = 0; i < board.length; i++) {
                String s = new String(board[i]);
                oneAns.add(s);
            }
            ans.add(oneAns);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0
                    && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;

                solve(col + 1, board, ans, leftRow, lowerDiagonal, upperDiagonal);

                // backtrack
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // initialize with empty space
                board[i][j] = '.';
            }
        }

        // initialize arrays to store if visited
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];

        solve(0, board, ans, leftRow, lowerDiagonal, upperDiagonal);

        return ans;
    }
}
