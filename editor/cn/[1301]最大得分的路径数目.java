
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final char OBSTACLE = 'X';

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        if (n == 2) {
            return new int[]{0, 0};
        }
        int[][] dp = new int[n][n];
        dp[n - 1][n - 1] = 0;
        for (int i = n - 2; i >= 0 && board.get(i).charAt(n - 1) != OBSTACLE; i--) {
            dp[i][n - 1] = dp[i - 1][n - 1] + board.get(i).charAt(n - 1);
        }
        for (int j = n - 2; j >= 0 && board.get(n - 1).charAt(j) != OBSTACLE; j--) {
            dp[n - 1][j] = dp[n - 1][j - 1] + board.get(n - 1).charAt(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = 
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
