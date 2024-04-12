class Solution {

    private int calWater(int [] height, int i, int j) {
        return (j - i) * Math.min(height[i], height[j]);
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int w = 0, ans = 0;

        while (l < r) {
            w = calWater(height, l, r);
            if (w > ans) {
                ans = w;
            }
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }
}
