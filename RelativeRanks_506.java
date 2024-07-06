class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        // pair stores score, index
        // priority queue with descending order of scores
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getKey() - a.getKey());

        for (int i = 0; i < n; i++) {
            pq.add(new Pair<>(score[i], i));
        }

        String[] ans = new String[n];
        int place = 1;

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll(); // max score
            int idx = pair.getValue();
            if (place == 1) {
                ans[idx] = "Gold Medal";
            } else if (place == 2) {
                ans[idx] = "Silver Medal";
            } else if (place == 3) {
                ans[idx] = "Bronze Medal";
            } else {
                ans[idx] = String.valueOf(place);
            }
            place++;
        }
        return ans;
    }
}
