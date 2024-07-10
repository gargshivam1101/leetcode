class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;

        for (int num: nums) {
            if (num <= small) {
                // num is the smallest
                small = num;
            } else if (num <= big) {
                // num is greater than small and less than big
                big = num;
            } else {
                // num is greater than both, which means triplet found
                return true;
            }
        }
        return false;
    }
}
