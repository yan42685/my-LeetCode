
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] preSum = null;

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isSpeedEnough(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isSpeedEnough(int[] piles, int totalHours, int speed) {
        int hours = 0;
        for (int pile : piles) {
            if (pile % speed == 0) {
                // 可以整除
                hours += pile / speed;
            } else {
                // 不能整除
                hours += pile / speed + 1;
            }
            // 提前结束循环
            if (hours > totalHours) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
