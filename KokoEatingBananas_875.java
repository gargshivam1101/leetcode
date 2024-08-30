class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, mid, high = Integer.MIN_VALUE;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            mid = (low + high) / 2;
            int temp = 0;
            for (int i = 0; i < piles.length; i++) {
                temp += Math.ceil((double) (piles[i]) / (double) (mid));
            }
            if (temp <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }
}
