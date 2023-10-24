
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 只用想象2x2矩阵是怎么翻转2次达成旋转90度效果就行了
    // 沿对角线翻转是为了将行变成列
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }
        for (int i = 0; i < n; i++) {
            // 左上到右下
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

//    // 逆时针90度
//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//
//        // 上下翻转
//        for (int i = 0; i < n / 2; i++) {
//            int[] temp = matrix[i];
//            matrix[i] = matrix[n - 1 - i];
//            matrix[n - 1 - i] = temp;
//        }
//
//        // 沿斜对角线翻转
//        for (int i = 0; i < n; i++) {
//            // 右上到左下
//            for (int j = n - 1; j > i; j--) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//    }
}

//leetcode submit region end(Prohibit modification and deletion)
