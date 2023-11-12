
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else if (mid + 1 < nums.length && nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
