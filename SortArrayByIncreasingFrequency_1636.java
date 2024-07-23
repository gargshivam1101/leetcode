class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Integer[] numsArr = new Integer[n];
        // better to use loop than streams as small data, less overhead
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        // custom comparator as per ques problem
        Arrays.sort(numsArr, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return Integer.compare(b, a);
            }
            return Integer.compare(freq.get(a), freq.get(b));
        });

        for (int i = 0; i < n; i++) {
            nums[i] = numsArr[i];
        }
        return nums;
    }
}
