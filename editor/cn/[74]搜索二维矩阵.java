
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 先根据每行第一个元素确定行
        // 小于等于目标值的最大值
        int top = 0;
        int bottom = matrix.length - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }
        // bottom是所在行, 区间在[min-1, max]
        if (bottom != -1) {
            int left = 0;
            int right = matrix[0].length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[bottom][mid] == target) {
                    return true;
                } else if (matrix[bottom][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
