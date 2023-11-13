//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 建议跳过此题，看懂题解也写不出来的
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        // 是否奇数
        if (total % 2 == 1) {
            return findKth(nums1, nums2, total / 2 + 1);
        } else {
            return (findKth(nums1, nums2, total / 2) + findKth(nums1, nums2, total / 2 + 1)) / 2.0;
        }
    }

    private int findKth(int[] nums1, int[] nums2, int k) {
        int right1 = Math.min(k - 1, nums1.length - 1);
        int right2 = Math.min(k - 1, nums2.length - 1);
        int left1 = 0;
        int left2 = 0;
        // 不断排除小于kth的数，并减少k
        while (true) {
            // 已知三个边界条件
            if (left1 == right1 + 1) {
                return nums2[left2 + k - 1];
            }
            if (left2 == right2 + 1) {
                return nums1[left1 + k - 1];
            }
            // 这个判断要放在最后因为需要前两个判断排除数组越界情况
            if (k == 1) {
                return Math.min(nums1[left1], nums2[left2]);
            }
            // 每次尽量排除k/2个数 [index, p]之间的数
            // 即将被排除的最大的数
            int p1 = Math.min(left1 + k / 2 - 1, right1);
            int p2 = Math.min(left2 + k / 2 - 1, right2);
            if (nums1[p1] <= nums2[p2]) {
                k -= p1 - left1 + 1;
                left1 = p1 + 1;
            } else {
                k -= p2 - left2 + 1;
                left2 = p2 + 1;
            }
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)
