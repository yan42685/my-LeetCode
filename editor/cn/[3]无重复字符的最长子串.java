import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            ++right;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char removed = s.charAt(left);
                ++left;
                window.put(removed, window.get(removed) - 1);
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
