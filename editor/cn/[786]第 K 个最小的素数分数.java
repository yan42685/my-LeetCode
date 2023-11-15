
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
            if (lessOrEqualCount(arr, mid) <= k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return new int[]{a, b};
    }

    private int lessOrEqualCount(int[] arr, double target) {
        int count = 0;
        // 分母索引
        int j = 1;
        while (j < arr.length) {
            int i = 0;
            while (i < j && (double) arr[i + 1] / arr[j] <= target) {
                ++i;
            }
            if (Math.abs((double) arr[i] / arr[j] - target) < EPSILON) {
                a = arr[i];
                b = arr[j];
            }
            count += i;
            j++;
        }
        return count;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
