//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        // 是否偶数
        if (total % 2 == 0) {
            return (findKth(nums1, nums2, total / 2) + findKth(nums1, nums2, total / 2 + 1)) / 2.0;
        } else {
            return findKth(nums1, nums2, total / 2 + 1);
        }
    }

    private int findKth(int[] nums1, int[] nums2, int k) {
        int left1 = 0;
        int right1 = nums1.length - 1;
        int left2 = 0;
        int right2 = nums2.length - 1;
        while (true) {
            // 闭区间为空
            if (left1 == nums1.length) {
                return nums2[left2 + k - 1];
            }
            if (left2 == nums2.length) {
                return nums1[left1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[left1], nums2[left2]);
            }
            int mid1 = left1 + (right1 - left1) / 2;
            int mid2 = left2 + (right2 - left2) / 2;
            if (nums1[mid1] <= nums2[mid2]) {
                int excludeCount = mid1 - left1 + 1;
                if (excludeCount == k) {
                    return nums1[mid1];
                } else if (excludeCount < k) {
                    left1 = mid1 + 1;
                    k -= excludeCount;
                } else {
                    right1 = mid1;
                    right2 = mid2;
                }
            } else if (nums1[mid1] > nums2[mid2]) {
                int excludeCount = mid2 - left2 + 1;
                if (excludeCount == k) {
                    return nums2[mid2];
                } else if (excludeCount < k) {
                    left2 = mid2 + 1;
                    k -= excludeCount;
                } else {
                    right1 = mid1;
                    right2 = mid2;
                }
            }
        }

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


//leetcode submit region end(Prohibit modification and deletion)
