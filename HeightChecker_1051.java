class Solution {
    public int heightChecker(int[] heights) {
        // can use Arrays.sort and make it shorter, but it would take O(nlogn)
        // can use count sort as heights[i] is max 100, so O(n) solution

        int[] count = new int[101]; // as max 100 elements
        for (int height : heights) {
            count[height]++;
        }

        int ans = 0;
        int j = 0; // pointer for count
        for (int i = 0; i < heights.length; i++) {
            while (j < count.length && count[j] == 0) {
                j++;
            }
            if (heights[i] != j) {
                ans++;
            }
            count[j]--;
        }
        return ans;
    }
}
