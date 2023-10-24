import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int strStart = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            ++right;
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(target.get(c))) {
                    ++valid;
                }
            }
            while (valid == target.size()) {
                if (right - left < minLength) {
                    // 只有当前length < minLength 时才更新strStart的值
                    strStart = left;
                    minLength = right - left;
                }
                char removed = s.charAt(left);
                ++left;
                if (target.containsKey(removed)) {
                    window.put(removed, window.get(removed) - 1);
                    if (window.get(removed).equals(target.get(removed) - 1)) {
                        --valid;
                    }
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(strStart, strStart + minLength);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
