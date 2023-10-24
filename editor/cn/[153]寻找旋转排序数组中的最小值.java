
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 左中心 相同元素收缩右侧 保证 mid != right 避免死循环
            int mid = left + (right - left) / 2;
            // 因为mid可能等于left, 所以只比较mid和right
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
                // 如果没有重复数字，这段代码不会执行
            } else {
                --right;
            }
        }
        return nums[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
