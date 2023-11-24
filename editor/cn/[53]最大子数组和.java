
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int tmpMax = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmpMax = Math.max(tmpMax + nums[i], nums[i]);
            result = Math.max(result, tmpMax);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
