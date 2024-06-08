class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> diff1 = new HashSet<>();
        Set<Integer> diff2 = new HashSet<>();
        Set<Integer> freq1 = new HashSet<>();
        Set<Integer> freq2 = new HashSet<>();

        for (int num : nums2) {
            freq2.add(num);
        }

        for (int num : nums1) {
            freq1.add(num);
            if (freq2.contains(num)) {
                continue;
            }
            diff1.add(num);
        }

        for (int num : nums2) {
            if (freq1.contains(num)) {
                continue;
            }
            diff2.add(num);
        }
        return Arrays.asList(new ArrayList<>(diff1), new ArrayList<>(diff2));
    }
}
