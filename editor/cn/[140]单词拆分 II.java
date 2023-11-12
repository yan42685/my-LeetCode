
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 建议和139对比一下
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        List<String> result = new LinkedList<>();
        backtrack(s, set, result, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(String s, Set<String> set, List<String> result, StringBuilder sb, int start) {
        if (start == s.length()) {
            result.add(sb.toString().trim());
            return;
        }
        // subString取的是 [start, end) 左闭右开区间
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (set.contains(word)) {
                int prevLength = sb.length();
                sb.append(word).append(" "); // 做选择
                backtrack(s, set, result, sb, end); // 下一轮
                sb.setLength(prevLength); // 撤销选择
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
