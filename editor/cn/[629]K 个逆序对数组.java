
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    int mod = (int)1e9+7;
    public int kInversePairs(int n, int k) {
        int[][] f = new int[n + 1][k + 1];
        int[][] sum = new int[n + 1][k + 1];
        f[1][0] = 1;
        Arrays.fill(sum[1], 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                f[i][j] = j < i ? sum[i - 1][j] : (sum[i - 1][j] - sum[i - 1][j - (i - 1) - 1] + mod) % mod;
                sum[i][j] = j == 0 ? f[i][j] : (sum[i][j - 1] + f[i][j]) % mod;
            }
        }
        return f[n][k];
    }
}
//
//public class Solution {
//
//    private static final int MOD = 1_000_000_007;
//
//    public int kInversePairs(int n, int k) {
//        int[][] dp = new int[n + 1][k + 1];
//
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = 1;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= k; j++) {
//                for (int p = 0; p <= Math.min(j, i - 1); p++) {
//                    dp[i][j] = (dp[i][j] + dp[i - 1][j - p]) % MOD;
//                }
//            }
//        }
//
//        return dp[n][k];
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
