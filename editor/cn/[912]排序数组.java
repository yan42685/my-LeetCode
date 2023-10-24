
//leetcode submit region begin(Prohibit modification and deletion)
// mergeSort
class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, temp, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int[] temp, int left, int right) {
        if (left == right) {
            return;
        }
        // 这是左中心，所以应该划分为[left, mid] [mid + 1, right]
        int mid = left + (right - left) / 2;
        sort(nums, temp, left, mid);
        sort(nums, temp, mid + 1, right);
        // 剪枝
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        merge(nums, temp, left, mid, right);
    }

    private void merge(int[] nums, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                // 左边合并完了
                nums[k] = temp[j++];
            } else if (j == right + 1) {
                // 右边合并完了
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
