
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int OBSTACLE = -1;
    private static final int MOD = (int) 1e9 + 7;
    private List<String> board;

    public int[] pathsWithMaxScore(List<String> board) {
        this.board = board;
        int n = board.size();
//        if (n == 2) {
//            return new int[]{0, 0};
//        }
        int[][] dp = new int[n][n];
        int[][] count = new int[n][n];
        dp[n - 1][n - 1] = 0;
        count[n - 1][n - 1] = 1;
        for (int i = n - 2; i >= 0 && getNum(i, n - 1) != OBSTACLE; i--) {
            dp[i][n - 1] = (dp[i + 1][n - 1] + getNum(i, n - 1)) % MOD;
            count[i][n - 1] = 1;
        }
        for (int j = n - 2; j >= 0 && getNum(n - 1, j) != OBSTACLE; j--) {
            dp[n - 1][j] = (dp[n - 1][j + 1] + getNum(n - 1, j)) % MOD;
            count[n - 1][j] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (getNum(i, j) == OBSTACLE) {
                    dp[i][j] = OBSTACLE;
                    count[i][j] = OBSTACLE;
                } else {
                    int[] res = getMaxAndCount(new int[]{dp[i + 1][j], count[i + 1][j]},
                            new int[]{dp[i][j + 1], count[i][j + 1]},
                            new int[]{dp[i + 1][j + 1], count[i + 1][j + 1]});
                    if (res[0] == OBSTACLE) {
                        dp[i][j] = OBSTACLE;
                        count[i][j] = OBSTACLE;
                    } else {
                        dp[i][j] = (res[0] + getNum(i, j)) % MOD;
                        count[i][j] = res[1];
                    }
                }
            }
        }
        return new int[]{dp[0][0], count[0][0]};
    }

    private int getNum(int row, int col) {
        char ch = board.get(row).charAt(col);
        if (ch == 'X') {
            return OBSTACLE;
        } else if (ch == 'E') {
            return 0;
        } else {
            return ch - '0';
        }
    }

    /**
     * 获取最大的score和总的count
     */
    private int[] getMaxAndCount(int[]... dps) {
        int max = OBSTACLE;
        int count = OBSTACLE;
        for (int[] dp : dps) {
            if (dp[0] > max) {
                // 初次遇到非OBSTACLE的点
                if (max == OBSTACLE) {
                    count = dp[1];
                }
                max = dp[0];
            } else if (dp[0] == max && max != OBSTACLE) {
                count = (count + dp[1]) % MOD;
            }
        }
        return new int[]{max, count};
    }
}


//leetcode submit region end(Prohibit modification and deletion)
