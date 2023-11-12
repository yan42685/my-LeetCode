
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        // 以num结尾的连续子数组最大和
        int tempSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (tempSum > 0) {
                tempSum += num;
            } else {
                tempSum = num;
            }
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
