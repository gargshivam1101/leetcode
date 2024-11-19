class Solution {

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (int n : adj.get(node)) {
            if (!visited[n]) {
                dfs(n, adj, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> neighbour = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    neighbour.add(j);
                }
            }
            adj.add(neighbour);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                ans++;
            }
        }
        return ans;
    }
}
