class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // approach 1: can use maps to store link of name and corresponding height
        // approach 2: can keep array indices -> used below

        int n = names.length;
        Integer[] idxArr = new Integer[n]; // have to use Integer instead of int for custom sort

        for (int i = 0; i < n; i++) {
            // initialize array with index values
            idxArr[i] = i;
        }

        Arrays.sort(idxArr, (a, b) -> heights[b] - heights[a]); // custom sort

        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = names[idxArr[i]];
        }
        return ans;
    }
}
