
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[p] = nums[i];
                ++p;
            }
        }
        while (p < nums.length) {
            nums[p] = 0;
            ++p;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
