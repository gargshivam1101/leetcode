class Solution {
    public int longestConsecutive(int[] nums) {
        // can be easily done by sorting and checking, but needs to be done in O(n), so cant sort
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        int ans = 0;

        for (int num: set) {
            if (set.contains(num - 1)) {
                // if the number is not beginnig of sequence, then leave it
                continue;
            }

            // number must be beginning
            int potential = 1;
            while (set.contains(++num)) {
                potential++;
            }
            ans = Math.max(ans, potential);
        }
        return ans;
    }
}
