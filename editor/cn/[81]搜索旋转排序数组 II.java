
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // base case 1: 相等
            if (nums[mid] == target) {
                return true;
            } else {
                // base case 2: 左中心，只剩两个元素或左边有重复元素时，target必定不等于nums[left]
                if (nums[mid] == nums[left]) {
                    // 不能写成left = mid + 1
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
        return false;
    }
}
/**
 * deprecated
 */
//public class Solution {
//    public boolean search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        // 因为二分存在两者情况，找target 或者找某一个位置，
//        // 用right = nums.length-1 和 while (left < right) 可以一套代码兼顾两种情况(找target或最值)
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (target == nums[mid]) {
//                return true;
//            }
//            // right part if sorted
//            if (nums[mid] < nums[right]) {
//                // target is located in the sorted part
//                if (target > nums[mid] && target <= nums[right]) {
//                    left = mid + 1;
//
//                } else {
//                    right = mid - 1;
//                }
//                // left part is sorted
//            } else if (nums[mid] > nums[right]) {
//                if (target >= nums[left] && target < nums[mid]) {
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//                // nums[mid] == nums[right] 两边都是unsorted，二段性被破坏了
//                // 两边都无序, 例如
//                // 2 2 2 2 2 1 2
//                // 2 1 2 2 2 2 2
//            } else {
//                // 恢复二段性
//                --right;
//            }
//        }
//        // 最后一次check
//        return nums[left] == target ? true : false;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
