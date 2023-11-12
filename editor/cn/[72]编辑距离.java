
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 这个状态压缩是根据下面的朴素解法优化而来，需要很熟练才能第一次写出来
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m == 0 || n == 0) {
            return m + n;
        }
        // dp[j] 表示将特定长度的字符串转换成 word2 的前 j-1 个字符(从0开始计数)需要的最少操作次数
        int[] dp = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }
        // 相当于一行一行地按列遍历，然后不断覆盖一行的状态
        for (int i = 1; i <= m; i++) {
            int leftUp = dp[0]; // dp[i-1][0]
            dp[0] += 1;  // 变成dp[i][0] 对应删除操作
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j]; // 用于更新leftUp  即dp[i-1][j-1]
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = leftUp;
                } else {
                    // 选择插入操作，则根据的状态是dp[i-1][j], 在一维状态里对应上一行的dp[j]
                    int insert = dp[j] + 1;
                    // dp[i][j-1]
                    int delete = dp[j - 1] + 1;
                    // leftUp
                    int replace = leftUp + 1;
                    dp[j] = Math.min(Math.min(insert, delete), replace);
                }
                leftUp = tmp;
            }
        }
        return dp[n];
    }
}


/**
 * 朴素版本
 */
//class Solution {
//    public int minDistance(String word1, String word2) {
//        int m = word1.length();
//        int n = word2.length();
//        // dp[i][j]表示将word1前i-1个字符转化成word2前j-1个字符需要的最少步骤
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 0; i <= m; i++) {
//            dp[i][0] = i; // i次删除
//        }
//        for (int j = 0; j <= n; j++) {
//            dp[0][j] = j; // j次插入
//        }
//        for (int i = 1; i <= m;i++) {
//            for (int j = 1; j <= n; j++) {
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    // 必有一次插入、删除、修改
//                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
//                }
//            }
//        }
//        return dp[m][n];
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
