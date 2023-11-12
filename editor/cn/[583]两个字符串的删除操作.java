
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            dp[j] = j;
        }
        for (int i = 1; i <= m; i++) {
            int leftUp = dp[0]; // dp[i-1][0]
            dp[0] += 1; // dp[i][0]
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = leftUp;
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + 1;
                }
                leftUp = tmp;
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
