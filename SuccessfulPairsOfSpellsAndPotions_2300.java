class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < spells.length; i++) {
            int low = 0, high = potions.length, mid;

            while (low < high) {
                mid = low + (high - low) / 2;

                if (spells[i] * 1l * potions[mid] >= success) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            ans.add(potions.length - high);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
