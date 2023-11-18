
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[3];
        dp[0 % 3] = 0;
        dp[1 % 3] = 1;
        dp[2 % 3] = 1;
        for (int i = 3; i <= n; i++) {
//            dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3] + dp[(i - 3) % 3];
            dp[i % 3] = dp[0] + dp[1] + dp[2];
        }
        return dp[n % 3];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
