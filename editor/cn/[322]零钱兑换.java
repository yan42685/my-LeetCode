
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 不用Integer.MAX 避免后面+1的时候溢出
        final int MAX = amount + 1;
        // dp[i]表示amount为i时需要的硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] == MAX ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
