class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            // empty needle matches at the beginning
            return 0;
        }
        if (haystack.length() == 0) {
            // empty haystack means no needle can match with this
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) {
                // can't accomodate needle after ith place in haystack
                // so solution cannot be found for sure
                break;
            }

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    // didn't match, begin with another i now
                    break;
                }
                if (j == needle.length() - 1) {
                    // reached the last idx, means we found a match
                    return i;
                }
            }
        }
        return -1;
    }
}
