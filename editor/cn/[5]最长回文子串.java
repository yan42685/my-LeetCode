
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); ++i) {
            int length = 1;
            int left = i - 1;
            int right = i + 1;
            // 左扩
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                --left;
                ++length;
            }
            // 右扩
            while (right <= s.length() - 1 && s.charAt(right) == s.charAt(i)) {
                ++right;
                ++length;
            }
            // 两边扩
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
                length += 2;
            }
            if (length > maxLength) {
                maxLength = length;
                startIndex = left + 1;
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
