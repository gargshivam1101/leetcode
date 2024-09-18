class Solution {
    public String largestNumber(int[] nums) {
        String[] numsStr = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(numsStr, (a, b) -> (b + a).compareTo(a + b));

        String ans = String.join("", numsStr);
        if (ans.startsWith("0")) {
            ans = "0";
        }

        return ans;
    }
}
