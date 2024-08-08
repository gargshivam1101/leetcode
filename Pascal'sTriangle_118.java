class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList(1)));
        for (int i = 1; i < n; i++) {
            List<Integer> in = new ArrayList<>();
            in.add(1);
            for (int j = 1; j < i; j++) {
                in.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            in.add(1);
            ans.add(in);
        }
        return ans;
    }
}
