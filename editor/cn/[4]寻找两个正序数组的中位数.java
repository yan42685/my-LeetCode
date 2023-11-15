//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

/**
 * 解空间视角二：[min, max]整数集合，思路更通用，但是要求解是整数，时间复杂度稍微高一点
 * 时间复杂度 O(log(m+n)log(max-min))
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numsCount = nums1.length + nums2.length;
        LinkedList<int[]> arrays = new LinkedList<>();
        arrays.add(nums1);
        arrays.add(nums2);
        if (numsCount % 2 == 1) {
            return getKth(arrays, numsCount / 2 + 1);
        } else {
            int leftMedian = getKth(arrays, numsCount / 2);
            int rightMedian = getKth(arrays, numsCount / 2 + 1);
            return (leftMedian + rightMedian) / 2.0;
        }
    }

    private int getKth(List<int[]> arrays, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int[] array : arrays) {
            if (array.length > 0) {
                left = Math.min(left, array[0]);
                right = Math.max(right, array[array.length - 1]);
            }
        }
        while (left <= right) {
            int count = 0;
            int mid = left + (right - left) / 2;
            for (int[] array : arrays) {
                count += lessOrEqualCount(array, mid);
            }
            if (count <= k - 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // left是所有数组中，不满足 count <= k-1 的最小的数
        return left;
    }

    private int lessOrEqualCount(int[] array, int target) {
        if (array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // right是满足 array[i] <= target 的最大的索引
        return right + 1;
    }
}

/**
 * 解空间视角一：指针排除，只在指针个数较少时能用，不要求解是整数
 * 时间复杂度 O(log(k)) == O(log(m+n))
 */
//public class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int numsCount = nums1.length + nums2.length;
//        // 奇数
//        if (numsCount % 2 == 1) {
//            return findKth(nums1, nums2, numsCount / 2 + 1, 0, 0);
//        } else {
//            double leftMidian = findKth(nums1, nums2, numsCount / 2, 0, 0);
//            double rightMidian = findKth(nums1, nums2, numsCount / 2 + 1, 0, 0);
//            return (leftMidian + rightMidian) / 2.0;
//        }
//    }
//
//    /**
//     * 作用：找到两个有序数组中第k小的元素
//     * 原理：
//     * 解空间是nums1[i, x] nums2[j, y]  x-i+y-j == k-1或k-2 所以必定存在x<=k/2<=y 或y<=k/2<=x
//     * i和j是解空间起点
//     * 一般情况每次排除Math.min(k/2, nums1.length - i) 或 Math.min(k/2, nums2.length-j)个数
//     * 边界条件是i == nums1.length || j == nums2.length || k-1 == 0
//     */
//    int findKth(int[] nums1, int[] nums2, int k, int i, int j) {
//        if (i == nums1.length) {
//            return nums2[j + k - 1];
//        }
//        if (j == nums2.length) {
//            return nums1[i + k - 1];
//        }
//        if (k == 1) {
//            return Math.min(nums1[i], nums2[j]);
//        }
//
//        // 可能被排除的最后一个索引
//        int index1 = Math.min(i + k / 2 - 1, nums1.length - 1);
//        int index2 = Math.min(j + k / 2 - 1, nums2.length - 1);
//        if (nums1[index1] <= nums2[index2]) {
//            return findKth(nums1, nums2, k - (index1 - i + 1), index1 + 1, j);
//        } else {
//            return findKth(nums1, nums2, k - (index2 - j + 1), i, index2 + 1);
//        }
//    }
//}
//

//leetcode submit region end(Prohibit modification and deletion)
