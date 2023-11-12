//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 与左边比较没有分类讨论的条件(不管比左边小还是大，都是收缩右边)，只能与右边比较了
            if (nums[mid] == nums[right]) {
                --right;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}

//class Solution {
//    public int findMin(int[] nums) {
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//            // 左中心 相同元素收缩右侧 mid != right
//            int mid = left + (right - left) / 2;
//            // 与nums[left]比较没有二段性，例如nums[mid] > nums[left] 有两种情况
//            // 1 2 3     ;    2 3 1   ;    3 1 2
//            // 所以尽量与 nums[right]比较
//            if (nums[mid] < nums[right]) {
//                right = mid;
//            } else if (nums[mid] > nums[right]) {
//                left = mid + 1;
//            } else {
//                --right;
//            }
//        }
//        return nums[left];
//    }
//}


//// 如果要找最大值，无论是否有重复数字
//class Solution {
//    public int findMax(int[] nums) {
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//            // 右中心 mid != left
//            int mid = left + (right - left + 1) / 2;
//            // 与nums[right]比较没有二段性，例如nums[mid] < nums[right] 有两种情况
//            // 1 2 3     ;    3 1 2
//            // 所以尽量与 nums[left]比较
//            if (nums[mid] > nums[left]) {
//                left = mid;
//            } else if (nums[mid] < nums[left]) {
//                right = mid - 1;
//            } else {
//                ++left;
//            }
//        }
//        return nums[left];
//    }
//}

//leetcode submit region end(Prohibit modification and deletion)
