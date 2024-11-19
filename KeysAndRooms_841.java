class Solution {

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int node) {
        visited[node] = true;
        List<Integer> canVisit = rooms.get(node);

        for (int i = 0; i < canVisit.size(); i++) {
            if (!visited[canVisit.get(i)]) {
                dfs(rooms, visited, canVisit.get(i));
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;

        dfs(rooms, visited, 0);

        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }
}
