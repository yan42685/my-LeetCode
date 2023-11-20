
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 没必要用动态规划，这个时间复杂度一样，并且更直观
 */
public class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private int[][][] memo;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(m, n, maxMove, startRow, startColumn);
    }

    private int dfs(int m, int n, int maxMove, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
        if (memo[row][col][maxMove] != -1) {
            return memo[row][col][maxMove];
        }
        int count = 0;
        count = (count + dfs(m, n, maxMove - 1, row - 1, col)) % MOD;
        count = (count + dfs(m, n, maxMove - 1, row + 1, col)) % MOD;
        count = (count + dfs(m, n, maxMove - 1, row, col - 1)) % MOD;
        count = (count + dfs(m, n, maxMove - 1, row, col + 1)) % MOD;
        memo[row][col][maxMove] = count;
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
