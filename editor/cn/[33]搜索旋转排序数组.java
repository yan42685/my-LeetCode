
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * while left <= right写法
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // base case 1: 相等
            if (nums[mid] == target) {
                return mid;
            } else {
                // base case 2: 左中心，只剩两个元素时，target必定不等于nums[left]
                if (nums[mid] == nums[left]) {
                    ++left;
                }
                // 左边和右边至少有一边是有序的
                // 假设左边有序
                else if (nums[mid] > nums[left]) {
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                    // 假设右边有序
                } else {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}


/**
 * deprecated
 */
//class Solution {
//    public int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        // 排除所有不符合条件的
//        while (left < right) {
//            // left <= mid <= right - 1
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else {
//                if (nums[mid] < nums[right]) {
//                    if (target > nums[mid] && target <= nums[right]) {
//                        left = mid + 1;
//                    } else {
//                        right = mid - 1;
//                    }
//                //
//                } else if (nums[mid] > nums[right]){
//                    if (target >= nums[left] && target < nums[mid]) {
//                        right = mid - 1;
//                    } else {
//                        left = mid + 1;
//                    }
//                } else {
//                    // 实际不存在这种情况
//                    // --right;
//                }
//            }
//        }
//        // 最后一次check，在排除所有不符合条件的数之后，最后的索引是否符合条件
//        return nums[left] == target ? left : -1;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
