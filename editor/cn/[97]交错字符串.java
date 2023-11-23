
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * dp定义应该只使用逻辑序数(从1开始)  而代码则将逻辑序数转化为物理序数(从0开始)
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        // dp[i][j] 表示 s1 的前 i 个字符和 s2 的前 j 个字符能否交错组成 s3 的前 i+j 个字符。
        // 其中s1第i个字符是s1[i-1]   s2的是s2[j-1]   s3的第i+j个字符是s3[i+j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                            || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
            }
        }
        return dp[m][n];
    }
}

/**
 * 压缩到二维，一般是从二维修改而来，不然一次性考虑太多东西容易出错
 */
//public class Solution {
//    public boolean isInterleave(String s1, String s2, String s3) {
//        int m = s1.length();
//        int n = s2.length();
//        if (m + n != s3.length()) {
//            return false;
//        }
//        boolean[] dp = new boolean[n + 1];
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                if (i == 0 && j == 0) {
//                    dp[j] = true;
//                } else if (i == 0) {
//                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
//                } else if (j == 0) {
//                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i - 1);
//                } else {
//                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
//                            || dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
//                }
//            }
//        }
//        return dp[n];
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
