
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 对比97题，如果方便初始化就多花点空间初始化，否则把逻辑都写在双重循环里
 */
class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private List<String> board;

    public int[] pathsWithMaxScore(List<String> board) {
        this.board = board;
        int n = board.size();
        // n + 1行和列，便于处理边界条件
        int[][] dp = new int[n + 1][n + 1];
        int[][] routes = new int[n + 1][n + 1];
        Arrays.fill(dp[n], -1);
        for (int i = 0; i < n; i++) {
            dp[i][n] = -1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char c = board.get(i).charAt(j);
                if (c == 'S') {
                    routes[i][j] = 1;
                    continue;
                } else if (c == 'X') {
                    dp[i][j] = -1;
                    continue;
                }
                int score = c == 'E' ? 0 : c - '0';
                int max = Math.max(Math.max(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]);
                if (max == -1) {
                    dp[i][j] = -1;
                    continue;
                } else {
                    dp[i][j] = (max + score) % MOD;
                    if (dp[i + 1][j] == max) {
                        routes[i][j] = (routes[i][j] + routes[i + 1][j]) % MOD;
                    }
                    if (dp[i][j + 1] == max) {
                        routes[i][j] = (routes[i][j] + routes[i][j + 1]) % MOD;
                    }
                    if (dp[i + 1][j + 1] == max) {
                        routes[i][j] = (routes[i][j] + routes[i + 1][j + 1]) % MOD;
                    }
                }
            }
        }
        return new int[]{dp[0][0] == -1 ? 0 : dp[0][0], routes[0][0]};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
