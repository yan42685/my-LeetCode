import java.util.HashMap;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> target = new HashMap<>(p.length());
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> result = new LinkedList<>();
        // 记住结论，表示 right取值范围是 [0, p.length() - 1]
        while (right < s.length()) {
            char c = s.charAt(right);
            ++right;
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(target.get(c))) {
                    ++valid;
                }
            }
            if (right - left == p.length()) {
                if (valid == target.size()) {
                    result.add(left);
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
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
