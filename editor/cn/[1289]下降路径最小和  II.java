
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int[] dp = new int[n];
        // 上一行的最小值和次小值
        int prevMin = Integer.MAX_VALUE;
        int prevSecondMin = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            dp[j] = grid[0][j];
            if (dp[j] < prevMin) {
                prevSecondMin = prevMin;
                prevMin = dp[j];
            } else {
                prevSecondMin = Math.min(dp[j], prevSecondMin);
            }
        }
        for (int i = 1; i < n; i++) {
            int currMin = Integer.MAX_VALUE;
            int currSecondMin = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int lastChoice = dp[j] != prevMin ? prevMin : prevSecondMin;
                dp[j] = lastChoice + grid[i][j];
                if (dp[j] < currMin) {
                    currSecondMin = currMin;
                    currMin = dp[j];
                } else {
                    currSecondMin = Math.min(dp[j], currSecondMin);
                }
            }
            prevMin = currMin;
            prevSecondMin = currSecondMin;
        }
        return prevMin;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
