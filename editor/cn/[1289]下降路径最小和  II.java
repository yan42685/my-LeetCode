
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int[] dp = new int[n];
        System.arraycopy(grid[0], 0, dp, 0, n);
        int prevMin = Integer.MAX_VALUE;
        int prevSecondMin = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            prevMin = Math.min(prevMin, dp[j]);
            prevSecondMin = dp[j] != prevMin ? Math.min(prevSecondMin, dp[j]) : prevSecondMin;
        }
        for (int i = 1; i < n; i++) {
            int currMin = Integer.MAX_VALUE;
            int currSecondMin = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int lastChoice = dp[j] != prevMin ? prevMin : prevSecondMin;
                dp[j] = lastChoice + grid[i][j];
                currMin = Math.min(currMin, dp[j]);
                currSecondMin = dp[j] != currMin ? Math.min(currSecondMin, dp[j]) : currSecondMin;
            }
            prevMin = currMin;
            prevSecondMin = currSecondMin;
        }
        return prevMin;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
