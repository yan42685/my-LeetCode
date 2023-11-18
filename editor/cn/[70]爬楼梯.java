
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[2];
        dp[1 % 2] = 1;
        dp[2 % 2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i % 2] = dp[0] + dp[1];
        }
        return dp[n % 2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
