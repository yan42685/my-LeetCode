
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 不用乘，防止溢出
            int tmp = x / mid;
            if (mid == tmp) {
                return mid;
            } else if (mid < tmp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 小于target的最大值
        return right;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
