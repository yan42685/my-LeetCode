
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[2];
        dp[1 % 2] = 0;
        dp[2 % 2] = Math.min(cost[0], cost[1]);
        for (int i = 3; i <= n; i++) {
            int oneCost = cost[i - 1] + dp[(i - 1) % 2];
            int twoCost = cost[i - 2] + dp[(i - 2) % 2];
            dp[i % 2] = Math.min(oneCost, twoCost);
        }
        return dp[n % 2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
