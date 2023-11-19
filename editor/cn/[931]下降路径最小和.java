
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n + 1];
        System.arraycopy(matrix[0], 0, dp, 0, n);
        dp[n] = Integer.MAX_VALUE;  // 虚拟边界
        for (int i = 1; i < n; i++) {
            int leftUp = dp[0];
            dp[0] = Math.min(dp[0], dp[1]) + matrix[i][0];
            for (int j = 1; j < n; j++) {
                int tmp = dp[j];
                dp[j] = Math.min(Math.min(leftUp, dp[j]), dp[j + 1]) + matrix[i][j];
                leftUp = tmp;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[i]);
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
