import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 建议和140对比一下
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int maxLength = Integer.MIN_VALUE;
        for (String str : wordDict) {
            maxLength = Math.max(maxLength, str.length());
        }
        boolean[] dp = new boolean[maxLength];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            int curr = i % maxLength;
            for (int j = Math.max(0, i - maxLength); j < i; j++) {
                if (dp[j % maxLength] && set.contains(s.substring(j, i))) {
                    dp[curr] = true;
                    break;
                }
                dp[curr] = false;  // 这一句不能放在判断之前，因为上面的if依赖的状态可能是dp[curr]
            }
        }
        return dp[s.length() % maxLength];
    }
}

//leetcode submit region end(Prohibit modification and deletion)
