class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;

        int start = 0;

        while (start <= n - m) {

            int j = 0;

            while (j < m &&
                   haystack.charAt(start + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return start;
            }

            start++;
        }

        return -1;
    }
}