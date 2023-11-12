
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            dp[j] += dp[j - 1] + s2.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) {
            int leftUp = dp[0];
            dp[0] += s1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = leftUp;
                } else {
                    dp[j] = Math.min(dp[j] + s1.charAt(i - 1), dp[j - 1] + s2.charAt(j - 1));
                }
                leftUp = tmp;
            }

        }
        return dp[n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
