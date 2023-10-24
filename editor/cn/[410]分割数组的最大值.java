
//leetcode submit region begin(Prohibit modification and deletion)
// 使用前缀和数组
class Solution {
    private int[] preSum = null;

    public int splitArray(int[] nums, int m) {
        this.preSum = new int[nums.length + 1];
        // nums中的最大值
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            this.preSum[i + 1] = this.preSum[i] + nums[i];
            left = nums[i] > left ? nums[i] : left;
        }
        // nums的和
        int right = this.preSum[this.preSum.length - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValid(m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isValid(int m, int capacity) {
        int count = 0;
        int currSum = 0;
        for (int i = 1; i < this.preSum.length; i++) {
            if (this.preSum[i] - currSum > capacity) {
                currSum = this.preSum[i - 1];
                ++count;
                if (count == m) {
                    return false;
                }
            }
        }
        return count < m;
    }
}

//public class Solution {
//    // 不使用前缀和数组
//    public int splitArray(int[] nums, int m) {
//        int left = 0;
//        int right = 0;
//        for (int num : nums) {
//            left = num > left ? num : left;
//            right += num;
//        }
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (isValid(nums, m, mid)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }
//
//    // 题目数据已经表明m <= nums.length所以这里不check
//    private boolean isValid(int[] nums, int m, int maxSum) {
//        int sum = 0;
//        // 已经分好组的数量
//        int count = 0;
//        for (int num : nums) {
//            sum += num;
//            if (sum > maxSum) {
//                sum = num;
//                ++count;
//                if (count == m) {
//                    return false;
//                }
//            }
//        }
//        // 因为并没有check最后一段
//        return count < m;
//    }
//
//}


//leetcode submit region end(Prohibit modification and deletion)
