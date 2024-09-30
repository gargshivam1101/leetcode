class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGasRem = 0, currGasRem = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGasRem += gas[i] - cost[i];

            currGasRem += gas[i] - cost[i];
            if (currGasRem < 0) {
                currGasRem = 0;
                start = i + 1; // try from next idx
            }
        }
        return totalGasRem >= 0 ? start : -1;
    }
}
