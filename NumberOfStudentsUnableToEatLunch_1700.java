class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int oneC = 0, zeroC = 0;

        for (int st: students) {
            if (st == 0) {
                zeroC++;
            } else {
                oneC++;
            }
        }

        for (int sd: sandwiches) {
            if (sd == 0) {
                // sandwich is of 0 type
                // check if there are users who want 0 type, otherwise return rem count
                if (zeroC == 0) {
                    return oneC;
                }
                zeroC--;
            } else {
                // sandwich is of 1 type
                if (oneC == 0) {
                    return zeroC;
                }
                oneC--;
            }
        }
        return 0;
    }
}
