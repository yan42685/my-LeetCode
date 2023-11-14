//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numsCount = nums1.length + nums2.length;
        // 奇数
        if (numsCount % 2 == 1) {
            return findKth(nums1, nums2, numsCount / 2 + 1, 0, 0);
        } else {
            double leftMidian = findKth(nums1, nums2, numsCount / 2, 0, 0);
            double rightMidian = findKth(nums1, nums2, numsCount / 2 + 1, 0, 0);
            return (leftMidian + rightMidian) / 2.0;
        }
    }

    /**
     * k从1开始算, i和j从1开始算，右开区间
     * 一般情况的解空间是nums1前面 i+1 个数，和nums2前面 j+1个数，其中i+j == k+1
     * 一般情况每次排除Math.min(k/2, nums1.length - i) 或 Math.min(k/2, nums2.length-j)个数
     * 边界条件是i == nums1.length || j == nums2.length || k == 1
     */
//    public int findKth(int[] nums1, int[] nums2, int k, int i, int j) {
//        if (i == nums1.length) {
//            return nums2[j + k - 1];
//        }
//        if (j == nums2.length) {
//            return nums1[i + k - 1];
//        }
//        if (k == 1) {
//            return Math.min(nums1[i], nums2[j]);
//        }
//        int nextI = Math.min(i + k / 2, nums1.length);
//        int nextJ = Math.min(j + k / 2, nums2.length);
//        if (nums1[i] <= nums2[j]) {
//            return findKth(nums1, nums2, k - (nextI - i), nextI, j);
//        } else {
//            return findKth(nums1, nums2, k - (nextJ - j), i, nextJ);
//        }
//    }
    public int findKth(int[] nums1, int[] nums2, int k, int i, int j) {
        if (i == nums1.length) {
            return nums2[j + k - 1];
        }
        if (j == nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if (i + k / 2 - 1 < nums1.length) {
            mid1 = nums1[i + k / 2 - 1];
        }
        if (j + k / 2 - 1 < nums2.length) {
            mid2 = nums2[j + k / 2 - 1];
        }

        if (mid1 < mid2) {
            return findKth(nums1, nums2, k - k / 2, i + k / 2, j);
        } else {
            return findKth(nums1, nums2, k - k / 2, i, j + k / 2);
        }
    }
}

/**
 * 建议跳过此题，看懂题解也写不出来的
 */
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
//        int right1 = nums1.length;
//        int right2 = nums2.length;
//        int left1 = 0;
//        int left2 = 0;
//        // 不断排除小于kth的数，并减少k
//        while (true) {
//            // 已知三个边界条件
//            if (left1 == right1) {
//                return nums2[left2 + k - 1];
//            }
//            if (left2 == right2) {
//                return nums1[left1 + k - 1];
//            }
//            // 这个判断要放在最后因为需要前两个判断排除数组越界情况
//            if (k == 1) {
//                return Math.min(nums1[left1], nums2[left2]);
//            }
//            // 排除k个元素
//            int p1 = Math.min(left1 + k / 2 - 1, right1 - 1);
//            int p2 = Math.min(left2 + k / 2 - 1, right2 - 1);
//            if (nums1[p1] <= nums2[p2]) {
//                k -= p1 - left1 + 1;
//                left1 = p1 + 1;
//            } else {
//                k -= p2 - left2 + 1;
//                left2 = p2 + 1;
//            }
//        }
//    }
//}
//

//leetcode submit region end(Prohibit modification and deletion)
