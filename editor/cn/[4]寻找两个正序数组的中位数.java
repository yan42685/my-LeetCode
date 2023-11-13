//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            return findKthElement(nums1, nums2, total / 2 + 1);
        } else {
            return (findKthElement(nums1, nums2, total / 2) + findKthElement(nums1, nums2, total / 2 + 1)) / 2.0;
        }
    }

    public int findKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int left = Math.max(0, k - n);
        int right = Math.min(k - 1, m - 1);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (k - mid - 1 < n && nums1[mid] > nums2[k - mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int nums1LeftMax = left == 0 ? Integer.MIN_VALUE : nums1[left - 1];
        int nums2LeftMax = left == k ? Integer.MIN_VALUE : nums2[k - left - 1];
        return Math.max(nums1LeftMax, nums2LeftMax);
    }

}

// 下面有带注释版
//public class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int total = nums1.length + nums2.length;
//        // 是否奇数
//        if (total % 2 == 1) {
//            return findKth(nums1, nums2, total / 2 + 1);
//        } else {
//            return (findKth(nums1, nums2, total / 2) + findKth(nums1, nums2, total / 2 + 1)) / 2.0;
//        }
//    }
//
//    private int findKth(int[] nums1, int[] nums2, int k) {
//        int m = nums1.length;
//        int n = nums2.length;
//        int index1 = 0;
//        int index2 = 0;
//        // 不断排除小于kth的数，并减少k
//        while (true) {
//            // 已知三个边界条件
//            if (index1 == m) {
//                return nums2[index2 + k - 1];
//            }
//            if (index2 == n) {
//                return nums1[index1 + k - 1];
//            }
//            // 这个判断要放在最后因为需要前两个判断排除数组越界情况
//            if (k == 1) {
//                return Math.min(nums1[index1], nums2[index2]);
//            }
//            // 每次尽量排除k/2个数 [index, p]之间的数
//            // 即将被排除的最大的数
//            int p1 = Math.min(index1 + k / 2 - 1, m - 1);
//            int p2 = Math.min(index2 + k / 2 - 1, n - 1);
//            if (nums1[p1] <= nums2[p2]) {
//                k -= p1 - index1 + 1;
//                index1 = p1 + 1;
//            } else {
//                k -= p2 - index2 + 1;
//                index2 = p2 + 1;
//            }
//        }
//    }
//}
//
//
//leetcode submit region end(Prohibit modification and deletion)
