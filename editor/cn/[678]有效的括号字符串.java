
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
        int left = 0;
        int auto = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ++left;
            } else if (ch == ')') {
                --left;
                if (left + auto < 0) {
                    return false;
                }
            } else if (ch == '*') {
                ++auto;
            }
        }
        return left + auto >= 0 && left <= auto ? true : false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
