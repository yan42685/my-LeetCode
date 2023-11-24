
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return b;
    }
}

//class Solution {
//    private static final int MOD = (int) 1e9 + 7;
//
//    public int fib(int n) {
//        if (n <= 1) {
//            return n;
//        }
//        int[] dp = {0, 1};
//        for (int i = 2; i <= n; i++) {
//            dp[i % 2] = (dp[(i - 1) % 2] + dp[(i - 2) % 2]) % MOD;
//        }
//        return dp[n % 2];
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
