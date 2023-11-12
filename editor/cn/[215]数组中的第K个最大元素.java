import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final Random RAND = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left,int right, int k) {
        if (left >= right) {
            return nums[left];
        }
        int[] pair = partition(nums, left, right);
        if (k >= pair[0] && k <= pair[1]) {
            return nums[k];
        } else if (k < pair[0]) {
            return quickSelect(nums, left, pair[0] - 1, k);
        } else {
            return quickSelect(nums, pair[1] + 1, right, k);
        }
    }

    // 三路划分
    private int[] partition(int[] nums, int left, int right) {
        // 随机选pivot并放在最左边, 优化近似有序数组
        int randomIndex = left + RAND.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int i = left + 1;
        int p = left + 1;
        int j = right;
        while (p <= j) {
            if (nums[p] == nums[left]) {
                ++p;
            } else if (nums[p] < nums[left]) {
                swap(nums, i++, p++);
            } else {
                swap(nums, j--, p);
            }
        }
        swap(nums, left, i - 1);
        return new int[] {i - 1, j};
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
