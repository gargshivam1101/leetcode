class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        int n = senate.length();

        for (int i = 0; i < n; i++) {
            // seperate the characters with their respective turns in their individual queue
            if (senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int rPos = r.poll();
            int dPos = d.poll();
            // compete, the one with smaller position will kick the other one out
            if (rPos < dPos) {
                r.offer(rPos + n);
            } else {
                d.offer(dPos + n);
            }
        }

        return !r.isEmpty() ? "Radiant" : "Dire";
    }
}
