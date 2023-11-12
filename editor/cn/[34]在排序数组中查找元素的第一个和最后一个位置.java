
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 不管数据条件，习惯性写上去
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        // 需要初始化
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                break;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (nums[mid] != target) {
            return new int[]{-1, -1};
        } else {
            left = mid;
            right = mid;
            while (left - 1 >= 0 && nums[left - 1] == target) {
                --left;
            }
            while (right + 1 < nums.length && nums[right + 1] == target) {
                ++right;
            }
            return new int[]{left, right};
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
