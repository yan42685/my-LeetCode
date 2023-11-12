
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isSpeedEnough(piles, h, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isSpeedEnough(int[] piles, int h, int speed) {
        int hours = 0;
        for (int pile : piles) {
            int quotient = pile / speed;
            // 整除
            if (quotient * speed == pile) {
                hours += quotient;
            } else {
                hours += quotient + 1;
            }
            // 剪枝
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
