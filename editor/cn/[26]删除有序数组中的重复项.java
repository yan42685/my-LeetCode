
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[p]) {
                ++p;
                nums[p] = nums[i];
            }
        }
        return p + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
