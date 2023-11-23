
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 贪心
 */
class Solution {
    public boolean checkValidString(String s) {
        // 记录下界和上界
        int leftMin = 0;
        int leftMax = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '('){
                ++leftMin;
                ++leftMax;
            } else if (ch == ')') {
                --leftMin;
                --leftMax;
            } else if (ch == '*') {
                // * -> ) 的选择可以撤销
                --leftMin;
                // * -> ( 的选择无法撤销，这是刚需
                ++leftMax;
            }
            if (leftMax < 0) {
                return false;
            }
            // 贪心，希望leftMin尽量为0，leftMax尽量大
            // 将 * -> ) 改为 * -> ‘’ 直到 leftMin == 0
//            leftMin = Math.max(leftMin, 0);
        }
        // 上面已经保证了右括号全部消除，下面需要保证左括号可以全部消除
//        return leftMin == 0;
        return leftMin <= 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
