
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLUSlength(String[] strs) {
        int result = -1;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() > result) {
                boolean isSpecial = true;
                for (int j = 0; j < strs.length; j++) {
                    if (i != j && isSubsequence(strs[i], strs[j])) {
                        isSpecial = false;
                        break;
                    }
                }
                if (isSpecial) {
                    result = Math.max(result, strs[i].length());
                }
            }
        }
        return result;
    }

    boolean isSubsequence(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.length() - i > s2.length() - j) {
                return false;
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                ++i;
            }
            ++j;
        }
        return i == s1.length();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
