class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // target = 12
        // position = [10,8,0,5,3]
        // speed = [2,4,1,1,3]

        int ans = 0;
        double[] timeArr = new double[target];
        for (int i = 0; i < position.length; i++) {
            timeArr[position[i]] = (double) (target - position[i]) / speed[i];
        }
      
        // timeArr = [12, 0, 0, 3, 0, 7, 0, 0, 1, 0, 1, 0, 0]
        
        double prev = 0.0;
        for (int i = target - 1; i >= 0; i--) {
            double cur = timeArr[i];
            if (cur > prev) {
                // in other case where if it is equal or less, it must have caught up
                prev = cur;
                ans++;
            }
        }
        return ans;
    }
}
