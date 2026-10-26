class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            int skipS = 0;

            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            int skipT = 0;

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            char c1 = (i >= 0) ? s.charAt(i) : '\0';
            char c2 = (j >= 0) ? t.charAt(j) : '\0';

            if (c1 != c2) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}