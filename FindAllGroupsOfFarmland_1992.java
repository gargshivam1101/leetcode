class Solution {

    private int[] helper(int[][] land, int i, int j) {
        int [] coord = new int[4];
        coord[0] = i;
        coord[1] = j;
        int r = i, c = j;
        
        while (r < land.length && land[r][j] == 1) {
            r++;
        }
        coord[2] = r - 1;

        while (c < land[0].length && land[i][c] == 1) {
            c++;
        }
        coord[3] = c - 1;

        for (int x = i; x < r; x++) {
            for (int y = j; y < c; y++) {
                land[x][y] = 0; // mark as visited
            }
        }
        return coord;
    }

    public int[][] findFarmland(int[][] land) {
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int[] partAns = helper(land, i, j);
                    ans.add(partAns);
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
