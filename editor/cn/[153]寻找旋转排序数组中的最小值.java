
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 如果取最值(解一定存在)则不写等号，  如果解不一定存在原数组则写等号
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 与左边比较没有分类讨论的条件(不管比左边小还是大，都是收缩右边)，只能与右边比较了
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}

//leetcode submit region end(Prohibit modification and deletion)
