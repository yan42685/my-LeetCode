
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
                --leftMin;  // * -> ) 的选择如果太多了可以撤销一部分
                ++leftMax;  // * -> ( 的选择只能多不能少
            }
            // 对'*'双重贪心，希望leftMin尽量为0，leftMax尽量大
            if (leftMax < 0) {
                return false;
            }
            // leftMin < 0 说明 * -> ) 太多了，要撤销成 * -> ""
            leftMin = Math.max(leftMin, 0);
        }
        // 上面已经保证了右括号全部消除，下面需要保证左括号可以全部消除
        return leftMin == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
