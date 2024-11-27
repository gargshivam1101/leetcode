class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (map.containsKey(sorted)) {
                List<String> op = map.get(sorted);
                op.add(str);
                map.put(sorted, op);

            } else {
                List<String> op = new ArrayList<>();
                op.add(str);
                map.put(sorted, op);
            }
        }

        for (String str : map.keySet()) {
            ans.add(map.get(str));
        }
        return ans;
    }
}
