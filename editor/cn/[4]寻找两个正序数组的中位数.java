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
     * 作用：找到两个有序数组中第k小的元素
     * 原理：
     * 解空间是nums1[i, x] nums2[j, y]  x-i+y-j == k-1或k-2 所以必定存在x<=k/2<=y 或y<=k/2<=x
     * i和j是解空间起点
     * 一般情况每次排除Math.min(k/2, nums1.length - i) 或 Math.min(k/2, nums2.length-j)个数
     * 边界条件是i == nums1.length || j == nums2.length || k-1 == 0
     */
    int findKth(int[] nums1, int[] nums2, int k, int i, int j) {
        if (i == nums1.length) {
            return nums2[j + k - 1];
        }
        if (j == nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        // 可能被排除的最后一个索引
        int index1 = Math.min(i + k / 2 - 1, nums1.length - 1);
        int index2 = Math.min(j + k / 2 - 1, nums2.length - 1);
        if (nums1[index1] <= nums2[index2]) {
            return findKth(nums1, nums2, k - (index1 - i + 1), index1 + 1, j);
        } else {
            return findKth(nums1, nums2, k - (index2 - j + 1), i, index2 + 1);
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)
