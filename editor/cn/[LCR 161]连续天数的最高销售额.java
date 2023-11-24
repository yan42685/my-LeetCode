
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSales(int[] sales) {
        int result = sales[0];
        int tmpMax = sales[0];
        for (int i = 1; i < sales.length; i++) {
            tmpMax = Math.max(tmpMax + sales[i], sales[i]);
            result = Math.max(result, tmpMax);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
