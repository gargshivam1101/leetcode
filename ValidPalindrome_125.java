class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder proS = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                proS.append(s.charAt(i));
            }
        }

        System.out.println(proS.toString());

        char[] proc = proS.toString().toCharArray();

        int low = 0, high = proc.length - 1;

        while (low <= high) {
            if (Character.toLowerCase(proc[low++]) != Character.toLowerCase(proc[high--])) {
                return false;
            }
        }
        return true;
    }
}
