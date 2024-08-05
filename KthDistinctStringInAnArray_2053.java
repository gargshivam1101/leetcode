class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> freq = new HashMap<>();

        for (String a: arr) {
            freq.put(a, freq.getOrDefault(a, 0) + 1);
        }

        for (String a: arr) {
            if (freq.get(a) == 1) {
                k--;
            }

            if (k == 0) {
                return a;
            }
        }
        return "";
    }
}
