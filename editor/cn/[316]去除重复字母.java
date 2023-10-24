import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int SIZE = 256;

    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new LinkedList<>();
        boolean[] inStack = new boolean[SIZE];
        int[] count = new int[SIZE];
        for (char c : s.toCharArray()) {
            ++count[c];
        }
        // 用到了单调栈的思想
        for (char c : s.toCharArray()) {
            --count[c];
            if (!inStack[c]) {
                // 满足最小字典序, 尽量找到最小的字符放在开头
                while (!stack.isEmpty() && c < stack.peek() && count[stack.peek()] > 0) {
                    inStack[stack.pop()] = false;
                }
                stack.push(c);
                inStack[c] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
