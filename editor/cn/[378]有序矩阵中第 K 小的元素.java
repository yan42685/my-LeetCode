
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int x = (int)Math.sqrt(k - 1);
        x = Math.min(x, n - 1); // 防止 x 超出界限

        int row = x, col = 0; // 第 x+1 行和第 x+1 列的起始位置
        int count = x * x; // 排除的元素数量

        while (count < k - 1) {
            if (col == n - 1 || (row > 0 && matrix[row - 1][x] < matrix[x][col])) {
                // 移动行指针
                row--;
            } else {
                // 移动列指针
                col++;
            }
            count++;
        }

        // 判断应该从行还是列中取元素
        if (row == 0 || (col < n && matrix[x][col] < matrix[row - 1][x])) {
            return matrix[x][col];
        } else {
            return matrix[row - 1][x];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
