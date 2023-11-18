
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int j = 1; j < n; j++) {
            dp[j] = obstacleGrid[0][j] == 0 ? dp[j - 1] : 0;
        }
        for (int i = 1; i < m; i++) {
            dp[0] = obstacleGrid[i][0] == 0 ? dp[0] : 0;
            for (int j = 1; j < n; j++) {
                dp[j] = obstacleGrid[i][j] == 0 ? dp[j-1] + dp[j] : 0;
            }
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
