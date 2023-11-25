
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 状态转移优化版，时间复杂度O(N * K) 空间复杂度O(N)
 * https://leetcode.cn/problems/k-inverse-pairs-array/solutions/1096189/tong-ge-lai-shua-ti-la-yi-ti-wu-jie-bao-ej4ym/
 * dp[i][j] i个数能形成k个逆序对的排列数
 * 第i个数最多增加i-1个逆序对，取决于i所在的位置
 * dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + ... + dp[i-1][j-(i-1)]
 * dp[i][j-1] =            dp[i-1][j-1] + ... + dp[i-1][j-1-(i-2)] + dp[i-1][j-1-(i-1)]
 * 上减下、移项，得到
 * dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-i] （如果j < i, 则为dp[i-1][j-i] == 0)
 */

class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[2][k + 1];
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            int prev = (i - 1) % 2;
            int curr = i % 2;
            dp[curr][0] = 1;
            for (int j = 1; j <= k; j++) {
                
            }
        }
    }
}


//class Solution {
//    private static final int MOD = (int) 1e9 + 7;
//
//    public int kInversePairs(int n, int k) {
//        // 如果状态转移方程中，列数永远小于 则可以只用一个一维数组，此题不行
//        int[][] dp = new int[2][k + 1];
//        dp[1][0] = 1;
//        for (int i = 2; i <= n; i++) {
//            int prev = (i - 1) % 2;
//            int curr = i % 2;
//            dp[curr][0] = 1;
//
//            for (int j = 1; j <= k; j++) {
//                dp[curr][j] = (dp[curr][j - 1] + dp[prev][j]) % MOD;
//                if (j >= i) {
//                    // 因为 a - b 中 a是取余后的数，所以差可能为负，不符合实际，需要+MOD修正一下
//                    dp[curr][j] = (dp[curr][j] - dp[prev][j - i] + MOD) % MOD;
//                }
//            }
//        }
//
//        return dp[n % 2][k];
//    }
//}


/**
 * 朴素实现 时间复杂度 O(N^2 * K) 空间复杂度 O(N * K)
 */
//class Solution {
//    private static final int MOD = (int) 1e9 + 7;
//
//    public int kInversePairs(int n, int k) {
//        int[][] dp = new int[n + 1][k + 1];
//        dp[1][0] = 1;
//        for (int i = 2; i <= n; i++) {
//            for (int j = 0; j <= k; j++) {
//                if (j == 0) {
//                    dp[i][j] = 1;
//                } else {
//                    for (int p = j; p >= Math.max(j - (i - 1), 0); p--) {
//                        dp[i][j] = (dp[i][j] + dp[i - 1][p]) % MOD;
//                    }
//                }
//            }
//        }
//        return dp[n][k];
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
