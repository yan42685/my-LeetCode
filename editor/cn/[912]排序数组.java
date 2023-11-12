
//leetcode submit region begin(Prohibit modification and deletion)
// mergeSort
//class Solution {
//    public int[] sortArray(int[] nums) {
//        int[] temp = new int[nums.length];
//        sort(nums, temp, 0, nums.length - 1);
//        return nums;
//    }
//
//    private void sort(int[] nums, int[] temp, int left, int right) {
//        if (left == right) {
//            return;
//        }
//        // 这是左中心，所以应该划分为[left, mid] [mid + 1, right]
//        int mid = left + (right - left) / 2;
//        sort(nums, temp, left, mid);
//        sort(nums, temp, mid + 1, right);
//        // 剪枝
//        if (nums[mid] <= nums[mid + 1]) {
//            return;
//        }
//        merge(nums, temp, left, mid, right);
//    }
//
//    private void merge(int[] nums, int[] temp, int left, int mid, int right) {
//        for (int i = left; i <= right; i++) {
//            temp[i] = nums[i];
//        }
//        int i = left;
//        int j = mid + 1;
//        for (int k = left; k <= right; k++) {
//            if (i == mid + 1) {
//                // 左边合并完了
//                nums[k] = temp[j++];
//            } else if (j == right + 1) {
//                // 右边合并完了
//                nums[k] = temp[i++];
//            } else if (temp[i] <= temp[j]) {
//                nums[k] = temp[i++];
//            } else {
//                nums[k] = temp[j++];
//            }
//        }
//    }
//}


// QuickSort

import java.util.Random;

class Solution {
    private static final Random RAND = new Random();

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] pair = partition(nums, left, right);
        sort(nums, left, pair[0] - 1);
        sort(nums, pair[1] + 1, right);
    }

    // 三路快速排序
    private int[] partition(int[] nums, int left, int right) {
        // 随机选pivot并放在最左边, 优化近似有序数组
        int pivot = left + RAND.nextInt(right - left + 1);
        swap(nums, left, pivot);
        int i = left + 1;
        int p = left + 1;
        int j = right;
        // [left+1, i-1] 小于pivot; [i, j]等于pivot; [j+1, right]大于pivot
        // 最后交换 left 和 i-1, 让最后一个pivot回到正确位置
        // 实际上是 p 和 j 在遍历数据
        while (p <= j) {
            if (nums[p] == nums[left]) {
                ++p;
            } else if (nums[p] < nums[left]) {
                swap(nums, i++, p++);
            } else {
                swap(nums, j--, p);
            }
        }
        swap(nums, left, i - 1);

        return new int[]{i - 1, j};
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
