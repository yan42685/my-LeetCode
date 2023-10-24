
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // 0~1000共1001个点
        int[] result = new int[1001];
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            result[from] += numPassengers;
            // 乘客再to下车，所以实际是result[from, to-1]增加乘客
            result[to] -= numPassengers;
        }

        for (int i = 0; i < result.length; i++) {
            if (i != 0) {
                result[i] += result[i - 1];
            }
            if (result[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
