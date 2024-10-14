class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> visited = new HashMap<>();
        int ans = 0;
        int left = 0; // start of the current window

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (visited.containsKey(c)) {
                left = Math.max(left, visited.get(c) + 1);
            }
            visited.put(c, right);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
