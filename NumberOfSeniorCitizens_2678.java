class Solution {
    public int countSeniors(String[] details) {
        int ans = 0, age;
        for (String detail: details) {
            age = 10 * Character.getNumericValue(detail.charAt(11)) + 
                Character.getNumericValue(detail.charAt(12));
            ans = (age > 60) ? ++ans: ans;
        }
        return ans;
    }
}
