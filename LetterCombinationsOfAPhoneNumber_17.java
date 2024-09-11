class Solution {

    private static final Map<Character, String> phoneMap = new HashMap<>();
    static {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }

    private void backtrack(String digits, int idx, StringBuilder curr, List<String> ans) {
        if (idx == digits.length()) {
            // parsed all
            ans.add(curr.toString());
            return;
        }

        char d = digits.charAt(idx);
        String lettersOfD = phoneMap.get(d);

        for (char lD : lettersOfD.toCharArray()) {
            curr.append(lD);
            backtrack(digits, idx + 1, curr, ans);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return ans;
        }
        backtrack(digits, 0, new StringBuilder(), ans);
        return ans;
    }
}
