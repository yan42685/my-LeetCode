import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] preSum = null;
    private Random random = new Random();

    public Solution(int[] w) {
        this.preSum = new int[w.length + 1];
        for (int i = 0; i < w.length; i++) {
            preSum[i + 1] = preSum[i] + w[i];
        }
    }

    public int pickIndex() {
        int left = 1;
        int right = this.preSum.length - 1;
        // 前闭后开 从[0,x) 到 [1, x + 1)
        int target = random.nextInt(this.preSum[right]) + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < this.preSum[mid]) {
                right = mid - 1;
            } else if (target > this.preSum[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)
