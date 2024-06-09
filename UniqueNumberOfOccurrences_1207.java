class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int val: arr) {
            int c = count.getOrDefault(val, 0);
            count.put(val, ++c);
        }
        
        Set<Integer> seen = new HashSet<>(count.values());
        return seen.size() == count.size();
    }
}
