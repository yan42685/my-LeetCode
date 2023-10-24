import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int BASE = 4;
    private static final int LENGTH = 10;

    List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> seen = new HashSet<>();
        Set<String> result = new HashSet<>();
        int windowHash = 0;
        int left = 0;
        int right = 0;
        // right无条件右移
        while (right < s.length()) {
            char c = s.charAt(right);
            ++right;
            windowHash = hash(windowHash, c, "expand");
            if (right - left == LENGTH) {
                if (seen.contains(windowHash)) {
                    result.add(s.substring(left, left + LENGTH));
                } else {
                    seen.add(windowHash);
                }
                char removed = s.charAt(left);
                ++left;
                windowHash = hash(windowHash, removed, "shrink");
            }
        }
        return new LinkedList<>(result);
    }

    private int hash(int originHash, char ch, String mode) {
        int num = -1;
        int result = -1;
        switch (ch) {
            case 'A':
                num = 0;
                break;
            case 'C':
                num = 1;
                break;
            case 'G':
                num = 2;
                break;
            case 'T':
                num = 3;
                break;
            default:
                throw new IllegalArgumentException("ch: " + ch);
        }
        if ("expand".equals(mode)) {
            result = originHash * BASE + num;
        } else if ("shrink".equals(mode)) {
            result = originHash - num * (int) Math.pow(BASE, LENGTH - 1);
        } else {
            throw new IllegalArgumentException("mode: " + mode);
        }
        return result;
    }
}
//leetcode submit region end()
