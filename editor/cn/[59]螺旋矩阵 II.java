
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int counter = 0;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = ++counter;
            }
            ++rowStart;

            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = ++counter;
            }
            --colEnd;

            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    matrix[rowEnd][i] = ++counter;
                }
                --rowEnd;
            }

            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; --i) {
                    matrix[i][colStart] = ++counter;
                }
                ++colStart;
            }
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
