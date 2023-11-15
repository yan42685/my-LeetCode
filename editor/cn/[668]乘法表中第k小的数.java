
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lessOrEqualCount(m, n, mid) <= k - 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int lessOrEqualCount(int m, int n, int x) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count;
    }
//    private int lessOrEqualCount(int m, int n, int target) {
//        int i = 0;
//        int j = n - 1;
//        int count = 0;
//        while (i <= m - 1 && j >= 0) {
//            if ((i + 1) * (j + 1) <= target) {
//                ++i;
//                count += j + 1;
//            } else {
//                --j;
//            }
//        }
//        return count;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
