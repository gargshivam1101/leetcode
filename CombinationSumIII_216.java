class Solution {
    private void backtrack(int k, int n, int last, List<Integer> curr, List<List<Integer>> ans) {
        if (n < 0) {
            // sum became more than required
            return;
        } else if (curr.size() == k && n == 0) {
            // we found an answer
            ans.add(new ArrayList<>(curr));
            return;
        } else if (curr.size() == k) {
            // no more tries left
            return;
        }

        // if curr already has i or smaller, then no need to add or check
        // as it must be covered in the past and we will generate redundant permutations
        for (int i = last + 1; i <= 9; i++) {
            // decrement n by the value we are going over atm
            curr.add(i);
            backtrack(k, n - i, i, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(k, n, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
}
