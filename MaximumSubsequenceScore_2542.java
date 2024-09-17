class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long ans = 0, sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // create a pair of both the lists: nums2 and nums1
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            pairs.add(new int[] { nums2[i], nums1[i] });
        }

        pairs.sort((a, b) -> Integer.compare(b[0], a[0]));

        for (int[] pair : pairs) {
            if (pq.size() == k) {
                sum -= pq.poll();
            }

            sum += pair[1];
            pq.offer(pair[1]);

            if (pq.size() == k) {
                // skip beginning when we haven't even parsed the initial k iterations
                ans = Math.max(ans, sum * (long) pair[0]);
            }
        }
        return ans;
    }
}
