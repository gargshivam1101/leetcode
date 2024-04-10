class Solution {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        char [] ques = s.toCharArray();

        for (int i = 0; i < ques.length; i++) {
            if (ques[i] == '(') {
                count++;
            } else if (ques[i] == ')') {
                if (count == 0) {
                    ques[i] = '?';
                } else {
                    count--;
                }
            }
        }
        // now all extra closing brackets are marked and count has extra opening brakcets
        count = 0;
        for (int i = ques.length - 1; i >= 0; i--) {
            if (ques[i] == ')') {
                count++;
            } else if (ques[i] == '(') {
                if (count == 0) {
                    ques[i] = '?';
                } else {
                    count--;
                }
            }
        }

        // now all is done, count must be 0 as it must be VPS
        String ans = "";

        for (int i = 0; i < ques.length; i++) {
            if (ques[i] != '?') {
                ans += ques[i];
            }
        }
        return ans;
    }
}
