
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lessOrEqualCount(nums, mid) <= k - 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int lessOrEqualCount(int[] nums, int target) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            while (j < nums.length && nums[j] - nums[i] <= target) {
                j++;
            }
            count += j - 1 - i;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
