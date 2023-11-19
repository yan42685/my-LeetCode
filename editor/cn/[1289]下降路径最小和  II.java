
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int[] dp = new int[n];
        System.arraycopy(grid[0], 0, dp, 0, n);
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[i]);
            secondMin = dp[i] != min ? Math.min(secondMin, dp[i]) : secondMin;
        }
        for (int i = 1; i < n; i++) {
            int tmpMin = Integer.MAX_VALUE;
            int tmpSecondMin = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int lastChoice = dp[j] != prevMin ? prevMin : prevSecondMin;
                dp[j] = lastChoice + grid[i][j];
                min = Math.min(min, dp[i]);
                secondMin = dp[i] != min ? Math.min(secondMin, dp[i]) : secondMin;
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
