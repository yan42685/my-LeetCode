
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = {0, 1};
        for (int i = 2; i <= n; i++) {
            dp[i % 2] = dp[(i - 1) % 2] + dp[(i - 2) % 2];
        }
        return dp[n % 2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
