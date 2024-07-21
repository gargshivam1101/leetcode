class Solution {
    public int equalPairs(int[][] grid) {
        int ans = 0;
        Map<List<Integer>, Integer> count1 = new HashMap<>();
        Map<List<Integer>, Integer> count2 = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                l.add(grid[i][j]);
            }
            int countOfList = count1.getOrDefault(l, 0);
            count1.put(l, ++countOfList);
        }

        for (int i = 0; i < grid.length; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                l.add(grid[j][i]);
            }
            int countOfList = count2.getOrDefault(l, 0);
            count2.put(l, ++countOfList);
        }

        for (Map.Entry<List<Integer>, Integer> c1 : count1.entrySet()) {
            ans += c1.getValue() * count2.getOrDefault(c1.getKey(), 0);
        }
        return ans;
    }
}
