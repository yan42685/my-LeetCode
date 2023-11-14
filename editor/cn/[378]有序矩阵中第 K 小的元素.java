
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countNotGreater(matrix, mid);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int countNotGreater(int[][] matrix, int target) {
        int n = matrix.length;
        int i = n - 1, j = 0;
        int count = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] > target) {
                i--;
            } else {
                count += i + 1;
                j++;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
