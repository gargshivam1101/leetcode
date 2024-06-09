class RecentCounter {
    private Queue<Integer> q;

    public RecentCounter() {
        this.q = new ArrayDeque<>();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000) {
            // old requests which need to be removed
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
