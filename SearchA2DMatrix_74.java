class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int beginRow = 0, endRow = rows - 1, col = cols - 1;

        while (beginRow <= endRow) {
            int midRow = (beginRow + endRow) / 2;

            if (target > matrix[midRow][col]) {
                beginRow = midRow + 1;
            } else if (target < matrix[midRow][0]) {
                endRow = midRow - 1;
            } else {
                // it means we have found the row where the element must lie
                // so basic binary search should work
                int beginCol = 0, endCol = col;

                while(beginCol <= endCol) {
                    int midCol = (beginCol + endCol) / 2;
                    if (target == matrix[midRow][midCol]) {
                        return true;
                    } else if (target < matrix[midRow][midCol]) {
                        endCol = midCol - 1;
                    } else {
                        beginCol = midCol + 1;
                    }
                }
                // if not found in this row, then will not be anywhere
                return false;
            }
        }
        return false;
    }
}
