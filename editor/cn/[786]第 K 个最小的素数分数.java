
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final double EPSILON = 1e-8;
    // 分子
    private int a;
    // 分母
    private int b;

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left = 0;
        double right = 1;
        a = 0;
        b = 0;
        // 等效 left <= right
        while (right - left < EPSILON) {
            double mid = (right + left) / 2.0;
            if (lessOrEqualCount(arr, mid) <= k - 1) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return new int[]{a, b}
    }

    private int lessOrEqualCount(int[] arr, double target) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            while (j < arr.length && i / (double) j > target) {
                j++;
            }
            
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
