class Solution {
    int ans = 0;

    private void dfs(int node, int parent, Map<Integer, List<List<Integer>>> adj) {
        if (!adj.containsKey(node)) {
            // we have reached the last city in that path
            return;
        }

        for (List<Integer> n : adj.get(node)) {
            int neighbour = n.get(0);
            int sign = n.get(1);
            if (neighbour != parent) {
                ans += sign; // if using original, then we need to flip, so sign increses value by 1, and for
                             // artifical, no flip required, so it just adds 0 to answer
                dfs(neighbour, node, adj);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        // given that n nodes and n - 1 edges and all are connected
        // it is an acyclic graph, each node is connected to only 1 other using 1 edge

        Map<Integer, List<List<Integer>>> adj = new HashMap<>();

        for (int[] c : connections) {
            if (!adj.containsKey(c[0])) {
                adj.put(c[0], new ArrayList<>());
            }

            adj.get(c[0]).add(Arrays.asList(c[1], 1)); // 1 denotes that we have a real connection between them, and
                                                       // might need to flip some later

            if (!adj.containsKey(c[1])) {
                adj.put(c[1], new ArrayList<>());
            }
            adj.get(c[1]).add(Arrays.asList(c[0], 0)); // 0 denotes that we have made an artifical connection, just to
                                                       // check who are the neighbours, even if opposite
        }
        dfs(0, -1, adj);
        return ans;

    }
}
