
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] preSum = null;

    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        preSum = new int[weights.length + 1];
        for (int i = 0; i < weights.length; i++) {
            preSum[i + 1] = preSum[i] + weights[i];
            max = weights[i] > max ? weights[i] : max;
        }
        int left = max;
        int right = preSum[preSum.length - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (checkCapacity(days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkCapacity(int days, int capacity) {
        int count = 0;
        int currentLoad = 0;
        for (int i = 1; i < this.preSum.length; i++) {
            if (this.preSum[i] - currentLoad > capacity) {
                currentLoad = this.preSum[i - 1];
                ++count;
                if (count == days) {
                    return false;
                }
            }
        }
        // 最后一段<capacity的没算上
        return count < days;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
