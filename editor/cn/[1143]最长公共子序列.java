
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int longestCommonSubsequence(String text1, String text2) {
//        int m = text1.length();
//        int n = text2.length();
//        // dp[i][j] 表示text1第i-1个字符结尾的子串 和 text2第j-1个字符结尾的子串的LCS长度
//        // 第-1个字符结尾表示空串
//        // 不用初始化，因为dp[i][0]和dp[0][j] 都为0，符合dp定义
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
//                }
//            }
//        }
//        return dp[m][n];
//    }
//}

/**
 * 线性空间版本, 可读性较差
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int leftUp = dp[0];  // dp[i-1][j-1], 从dp[i-1][0] 开始
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = leftUp + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                leftUp = tmp;
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
