
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
        // 等效while (left < right)
        while (Math.abs(right - left) > EPSILON) {
            double mid = left + (right - left) / 2;
            if (lessOrEqualCount(arr, mid) <= k - 1) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return new int[]{a, b};
    }

    private int lessOrEqualCount(int[] arr, double target) {
        int count = 0;
        int i = 0;  // 分子索引
        // 分母索引
        for (int j = 1; j < arr.length; j++) {
            while (i + 1 < j && (double) arr[i + 1] / arr[j] <= target) {
                ++i;
            }
            // 当 i = j-1 且 (double) arr[i] / arr[j] > target时不应增加count
            if ((double) arr[i] / arr[j] <= target) {
                count += i + 1;
            }
            // 记录target
            if (Math.abs((double) arr[i] / arr[j] - target) < EPSILON) {
                a = arr[i];
                b = arr[j];
            }
        }
        return count;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
