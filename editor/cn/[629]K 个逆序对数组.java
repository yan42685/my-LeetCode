
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * https://leetcode.cn/problems/k-inverse-pairs-array/solutions/1096189/tong-ge-lai-shua-ti-la-yi-ti-wu-jie-bao-ej4ym/
 * dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + ... + dp[i-1][j-(i-1)]
 * dp[i][j-1] =            dp[i-1][j-1] + ... + dp[i-1][j-1-(i-2)] + dp[i-1][j-1-(i-1)]
 * 上减下、移项，得到
 * dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-i]
 */
class Solution {
    int mod = 1000000007;

    public int kInversePairs(int n, int k) {
        if (k > maxPairs(n)) {
            return 0;
        }
        //dp[i][j]表示到n为止，逆序数为k的个数
        int dp[][] = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            //0个逆序数对只有一种情况
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(k, maxPairs(i)); j++) {
                //从前面可以得到dp[i][j] = sum(dp[i-1][m])，m >= Math.max(0, j - i + 1)
                //这里是歪打正着，那就来分析一下为什么会这样
                //dp[i][j] = dp[i - 1][j - i + 1] + dp[i - 1][j - i + 2] + ... + dp[i - 1][j];
                //dp[i][j - 1] = dp[i - 1][j - 1 - i + 1] + dp[i - 1][j - 1 - i + 1] + ... + dp[i - 1][j - 1];
                //dp[i][j] - dp[i - 1][j - 1] = dp[i - 1][j] - dp[i - 1][j - i]
                //由于j - 1 - i可能小于0，因此减的时候需要判断避免越界
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j] - (j - i + 1 > 0 ? dp[i - 1][j - i] : 0)) % mod;
                //由于取模后减出来可能是负数，需要特殊处理
                if (dp[i][j] < 0) {
                    dp[i][j] += mod;
                }
            }
        }
        return dp[n][k];
    }

    /**
     * n个数，最大逆序数对数量(1 + 2 + 3 + ... + n-1)
     */
    int maxPairs(int n) {
        return n * (n - 1) / 2;
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
//                    preSum[i][j] = 1;
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
//leetcode submit region end(Prohibit modification and deletion)
