
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 1. dp[i][j]表示长度为n的自然数数组拥有k个逆序对的排列个数
 * 每次++i，新增逆序对个数 p ∈ [0, i-1]，又希望总逆序对为j个
 * 所以上一次的状态是 dp[i-1][j-p]，p ∈ [0, min(j, i-1)]
 * 所以dp[i][j] = sum(dp[i-1][j-p]), p ∈ [0, min(j, i-1)]
 * 2. 由于存在连续项求和，所以用前缀数组优化
 */
//class Solution {
//    private static final int MOD = (int) 1e9 + 7;
//
//    public int kInversePairs(int n, int k) {
//        if (k > (n * (n - 1)) / 2) {
//            return 0;
//        }
//        int[][] dp = new int[n + 1][k + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= k; j++) {
//                if (j == 0) {
//                    dp[i][j] = 1;
//                    continue;
//                }
//                for (int p = 0; p <= Math.min(j, i - 1); p++) {
//                    dp[i][j] = (dp[i][j] + dp[i - 1][j - p]) % MOD;
//                }
//            }
//        }
//        return dp[n][k];
//    }
//}

class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int kInversePairs(int n, int k) {
        if (k > (n * (n - 1)) / 2) {
            return 0;
        }

        int[][] dp = new int[n + 1][k + 1];
        int[] sum = new int[k + 1];  // 前缀和数组在循环外部创建
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            sum[0] = dp[i - 1][0];

            for (int j = 1; j <= k; j++) {
                sum[j] = (sum[j - 1] + dp[i - 1][j]) % MOD;
            }

            for (int j = 0; j <= k; j++) {
                dp[i][j] = sum[j];
                if (j >= i) {
                    dp[i][j] = (dp[i][j] - sum[j - i] + MOD) % MOD;
                }
            }
        }

        return dp[n][k];
    }
}
//class Solution {
//    int mod = (int) 1e9 + 7;
//
//    public int kInversePairs(int n, int k) {
//        int[][] f = new int[n + 1][k + 1];
//        int[][] sum = new int[n + 1][k + 1];
//        f[1][0] = 1;
//        Arrays.fill(sum[1], 1);
//        for (int i = 2; i <= n; i++) {
//            for (int j = 0; j <= k; j++) {
//                f[i][j] = j < i ? sum[i - 1][j] : (sum[i - 1][j] - sum[i - 1][j - (i - 1) - 1] + mod) % mod;
//                sum[i][j] = j == 0 ? f[i][j] : (sum[i][j - 1] + f[i][j]) % mod;
//            }
//        }
//        return f[n][k];
//    }
//}
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
