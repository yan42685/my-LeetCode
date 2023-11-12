
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // 前i个包裹重量和，从1开始计数
        int[] preSum = new int[weights.length + 1];
        int maxWeight = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length; i++) {
            preSum[i + 1] = preSum[i] + weights[i];
            maxWeight = Math.max(maxWeight, weights[i]);
        }
        int left = maxWeight;
        int right = preSum[preSum.length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isCapacityEnough(preSum, days, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // left是满足条件的最小值  right是不满足条件的最大值
        return left;
    }

    private boolean isCapacityEnough(int[] preSum, int days, int capacity) {
        int daysNeeded = 0;
        int prev = 0;
        for (int i = 1; i < preSum.length; i++) {
            if (preSum[i] - prev > capacity) {
                prev = preSum[i - 1];
                ++daysNeeded;
                if (daysNeeded > days) {
                    return false;
                }
            }
        }
        return daysNeeded + 1 <= days;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
