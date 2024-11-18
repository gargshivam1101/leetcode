class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (adj[prerequisite] == null) {
                adj[prerequisite] = new ArrayList<>();
            }
            adj[prerequisite].add(course); // build adjaceny list from matrix
            indegree[course]++; // calculate the number of incoming edges
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // initialize queue by adding all nodes with indegree 0
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int visitCount = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            visitCount++;

            if (adj[node] != null) {
                for (int neighbour : adj[node]) {
                    indegree[neighbour]--;
                    if (indegree[neighbour] == 0) {
                        q.offer(neighbour);
                    }
                }
            }
        }
        return visitCount == numCourses;
    }
}
