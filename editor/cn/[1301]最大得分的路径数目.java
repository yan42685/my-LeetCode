
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int OBSTACLE = -1;
    private static final int MOD = (int) 1e9 + 7;
    private List<String> board;

    public int[] pathsWithMaxScore(List<String> board) {
        this.board = board;
        int n = board.size();
        if (n == 2) {
            return new int[]{0, 0};
        }
        int[][] dp = new int[n][n];
        int[][] count=  new int[n][n];
        dp[n - 1][n - 1] = 0;
        for (int i = n - 2; i >= 0 && getNum(i, n - 1) != OBSTACLE; i--) {
            dp[i][n - 1] = (dp[i + 1][n - 1] + getNum(i, n - 1)) % MOD;
        }
        for (int j = n - 2; j >= 0 && getNum(n - 1, j) != OBSTACLE; j--) {
            dp[n - 1][j] = (dp[n - 1][j + 1] + getNum(n - 1, j)) % MOD;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (getNum(i, j) != OBSTACLE && !(i == 0 && j == 0)) {
                    int max = Math.max(Math.max(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]);
                    dp[i][j] = max == OBSTACLE ? OBSTACLE : (max + getNum(i, j)) % MOD;
                }
            }
        }
        int max = Math.max(dp[0][1], dp[1][0]);
        if (max == 0 && dp[1][1] == OBSTACLE) {
            return new int[]{0, 0};
        } else {
            int count = dp[0][1] == dp[1][0] ? 2 : 1;
            return new int[]{max, count};
        }
    }

    private int getNum(int row, int col) {
        char ch = board.get(row).charAt(col);
        if (ch == 'X') {
            return OBSTACLE;
        } else {
            return ch - '0';
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
