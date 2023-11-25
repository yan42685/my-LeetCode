
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 1. dp[i][j]表示长度为n的自然数数组拥有k个逆序对的排列个数
 * 每次++i，新增逆序对个数 p ∈ [0, i-1]，又希望总逆序对为j个
 * 所以上一次的状态是 dp[i-1][j-p]，p ∈ [0, min(j, i-1)]
 * 所以dp[i][j] = sum(dp[i-1][j-p]), p ∈ [0, min(j, i-1)]
 * dp[i][j-1] = sum(dp[i-1][j-1-p]), p ∈ [0, min(j, i-1)]
 * 所以dp[i][j] = 
 * 2. 由于存在连续项求和，所以用前缀数组优化
 * <p>
 * dp[i][j]表示长度为n的自然数数组拥有k个逆序对的排列个数
 * 怎么划分dp[i][j]的子集? -> 将第i个数放在哪
 * dp[i-1][j] -> 放在末尾
 * dp[i][j-1] -> 放在所有地方
 * dp[i-1][j-1] -> 放在使得逆序对大于k的地方, 最关键的一点
 *
 */

class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    if (j >= i) {
                        dp[i][j] = (dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + MOD) % MOD;
                    } else {
                        dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                    }
                }
            }
        }

        return dp[n][k];
    }
}

//class Solution {
//    private static final int MOD = (int) 1e9 + 7;
//
//    public int kInversePairs(int n, int k) {
//        int[][] dp = new int[n + 1][k + 1];
//        int[][] preSum = new int[n + 1][k + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= k; j++) {
//                if (j == 0) {
//                    dp[i][j] = 1;
////                    preSum[i][j] = 1;
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
//
//leetcode submit region end(Prohibit modification and deletion)
