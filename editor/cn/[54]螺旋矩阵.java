import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>((rowEnd + 1) * (colEnd + 1));
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // traverse right
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            ++rowStart;
            // traverse down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            --colEnd;
            // traverse left
            // 不是最底下的一行
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                --rowEnd;
            }
            // traverse up
            // 不是最左边的一列
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
                ++colStart;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
