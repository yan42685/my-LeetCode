
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 解空间是[min, max]之间的整数集合，min是左上角，max是右下角
 * 时间复杂度O(Nlog(max-min))  空间O(1)
 * 相对于第4题，只有一种解空间看法是可以写出代码的
 * 如果矩阵的数据换成浮点数则不能用这个方法
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lessOrEqualCount(matrix, mid) <= k - 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private int lessOrEqualCount(int[][] matrix, int target) {
        int n = matrix.length;
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i <= n - 1 && j >= 0) {
            if (matrix[i][j] <= target) {
                count += j + 1;
                ++i;
            } else {
                --j;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
