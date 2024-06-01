class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxVal = 0; // as candies[i] is always greater than 1

        for (int candy: candies) {
            if (maxVal < candy) {
                maxVal = candy;
            }
        }

        List<Boolean> ans = new ArrayList<>();
        int diff = maxVal - extraCandies;
        for (int candy: candies) {
            if (candy >= diff) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}
