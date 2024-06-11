class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];

        for (int arr : arr1) {
            count[arr]++;
        }

        int[] ans = new int[arr1.length];
        int i = 0;

        for (int arr : arr2) {
            while (count[arr] != 0) {
                ans[i++] = arr;
                count[arr]--;
            }
        }

        // missing elements remaining
        for (int j = 0; j < 1001; j++) {
            while (count[j] != 0) {
                ans[i++] = j;
                count[j]--;
            }
        }

        return ans;
    }
}
