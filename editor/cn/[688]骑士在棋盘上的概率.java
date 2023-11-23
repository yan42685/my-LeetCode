
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int[][] DIRECTIONS = {{-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};
    private double[][][] memo;

    public double knightProbability(int n, int k, int row, int column) {
        memo = new double[n][n][k + 1];
        for (double[][] matrix : memo) {
            for (double[] line : matrix) {
                Arrays.fill(line, -1.0);
            }
        }
        return dfs(n, k, row, column);
    }

    private double dfs(int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0.0;
        }
        if (k == 0) {
            return 1.0;
        }
        if (memo[row][column][k] >= 0) {
            return memo[row][column][k];
        }
        double result = 0.0;
        for (int[] direction : DIRECTIONS) {
            result += dfs(n, k - 1, row + direction[0], column + direction[1]) / 8.0;
        }
        memo[row][column][k] = result;
        return result;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
