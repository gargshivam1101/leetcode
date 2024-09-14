class SmallestInfiniteSet {
    public PriorityQueue<Integer> pq;
    int count = 1;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<Integer>();
    }

    public int popSmallest() {
        if (pq.isEmpty() || (pq.peek() >= count)) {
            // return current count and increment value by 1
            return count++;
        } else {
            return pq.poll();
        }
    }

    public void addBack(int num) {
        if (num < count && !pq.contains(num)) {
            pq.add(num);
        }

    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
