
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int count;
    private int[] temp;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        count = 0;
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return count;
    }

    private void sort(int[] nums, int left, int right) {
        if (left == right) {
            return;

        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int p = mid + 1;
        for (int i = left; i <= mid; i++) {
            // 转型成long防止溢出
            while (p <= right && (long) nums[i] > 2 * (long) nums[p]) {
                ++p;
            }
            count += (p - mid - 1);
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == right+ 1) {
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
