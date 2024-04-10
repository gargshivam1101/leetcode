class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        for (i = 0; i < deck.length; i++) {
            queue.add(i);
        }

        int [] ans = new int [deck.length];
        i = 0;
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            ans[idx] = deck[i];
            if (!queue.isEmpty()) {
                int val = queue.poll();
                queue.add(val);
            }
            i++;
        }
        return ans;
    }
}
