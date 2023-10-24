
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        final int UPPER_BOUND = (int) 1e9;
        int left = 0;
        int right = UPPER_BOUND;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMake(bloomDay, mid, m, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return canMake(bloomDay, left, m, k) ? left : -1;
    }

    private boolean canMake(int[] bloomDay, int waitDays, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        for (int day : bloomDay) {
            if (day <= waitDays) {
                ++flowers;
                if (flowers == k) {
                    ++bouquets;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }

            if (bouquets == m) {
                return true;
            }
        }
        return false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
