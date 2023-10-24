
//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    private int[] preSum;

    public NumArray(int[] nums) {
        // this.preSum[0] = 0  虚拟头结点
        this.preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            this.preSum[i + 1] = this.preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // 逻辑上为preSum[right] - preSum[left - 1], 实现中多了个虚拟头结点
        return this.preSum[right + 1] - this.preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
