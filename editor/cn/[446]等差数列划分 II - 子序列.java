
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * HashMap优化版，如果重复元素较少，则O(N^2)  如果全是重复元素会退化到O(N^3)
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        // 记录所有元素的下标，用List存储重复元素的下标
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // absent ? put new : get old,  finally return
            map.computeIfAbsent(nums[i], k -> new LinkedList<Integer>()).add(i); // compute->新值；put->旧值
        }
        int result = 0;
        // 以j, i结尾的子序列包含等差数列的个数，其中dp[i][j] = sum(dp[j][k] + 1)
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long target = 2L * nums[j] - nums[i];
                if (target < Integer.MIN_VALUE || target > Integer.MAX_VALUE) {
                    continue;
                }
                // 将long转化成int是必要的，因为map.getOrDefault(Object) 查找Long类型会返回null
                for (int k : map.getOrDefault((int) target, Collections.emptyList())) {
                    if (k < j) {
                        dp[i][j] += dp[j][k] + 1;
                    } else {
                        break;
                    }
                }
                result += dp[i][j];
            }
        }
        return result;

    }
}
/**
 * 朴素思路
 */
//class Solution {
//    public int numberOfArithmeticSlices(int[] nums) {
//        int n = nums.length;
//        if (n < 3) {
//            return 0;
//        }
//
//        int result = 0;
//        // 以j, i结尾的子序列包含等差数列的个数，其中dp[i][j] = sum(dp[j][k] + 1)
//        int[][] dp = new int[n][n];
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                long target = 2L * nums[j] - nums[i];
//                if (target < Integer.MIN_VALUE || target > Integer.MAX_VALUE) {
//                    continue;
//                }
//
//                for (int k = 0; k < j; k++) {
//                    if (nums[k] == target) {
//                        dp[i][j] += dp[j][k] + 1;
//                    }
//                }
//                result += dp[i][j];
//            }
//        }
//
//        return result;
//    }
//}


//leetcode submit region end(Prohibit modification and deletion)
