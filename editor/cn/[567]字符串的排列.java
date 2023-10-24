import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> target = new HashMap<>(s1.length());
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        // when window.get(c).equals(target.get(c)) ++validCount
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            ++right;
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(target.get(c))) {
                    ++valid;
                }
            }
            // shrink left
            if (right - left == s1.length()) {
                if (valid == target.size()) {
                    return true;
                }
                char removed = s2.charAt(left);
                ++left;
                if (target.containsKey(removed)) {
                    window.put(removed, window.get(removed) - 1);
                    if (window.get(removed).equals(target.get(removed) - 1)) {
                        --valid;
                    }
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
