
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minTime(int[] time, int m) {
        int left = 0;
        // (10^5 x 10^4) / 1
        int right = (int) 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isTimeEnough(time, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isTimeEnough(int[] time, int totalDays, int timePerDay) {
        int passedDays = 0;
        int maxTime = 0;
        int currTime = 0;
        for (int t : time) {
            maxTime = Math.max(maxTime, t);
            currTime += t;
            if (currTime - maxTime > timePerDay) {
                passedDays++;
                if (passedDays == totalDays) {
                    return false;
                }
                maxTime = t;
                currTime = t;
            }
        }
        // 最后一天没计算
        return passedDays < totalDays;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
