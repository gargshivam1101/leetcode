class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int left = candidates - 1, right = costs.length - candidates;

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for (int i = 0; i < candidates; i++) {
            pq1.offer(costs[i]);
        }

        for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
            // even if length of pq2 is smaller, don't add duplicates
            pq2.add(costs[i]);
        }

        long ans = 0;

        while (k-- > 0) {
            // the two pq dont overlap yet
            if (pq1.isEmpty() || !pq2.isEmpty() && pq1.peek() > pq2.peek()) {
                // remove from right one, and add rightmost
                ans += (long) pq2.poll();
                if (left < right - 1) {
                    right--;
                    pq2.offer(costs[right]);
                }

            } else {
                ans += (long) pq1.poll();
                if (left < right - 1) {
                    left++;
                    pq1.offer(costs[left]);
                }
            }
        }
        return ans;

    }
}
