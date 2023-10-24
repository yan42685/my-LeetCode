
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd) {
            int mid = rowStart + (rowEnd - rowStart) / 2;
            if (target < matrix[mid][0]) {
                rowEnd = mid - 1;
            } else if (target > matrix[mid][0]) {
                rowStart = mid + 1;
            } else {
                return true;
            }
        }
        if (rowStart == 0) {
            return false;
        }
        while (colStart <= colEnd) {
            int mid = colStart + (colEnd - colStart) / 2;
            if (target < matrix[rowStart - 1][mid]) {
                colEnd = mid - 1;
            } else if (target > matrix[rowStart - 1][mid]) {
                colStart = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
