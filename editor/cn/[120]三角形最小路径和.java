
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int minimumTotal(List<List<Integer>> triangle) {
//        // 实际是n x n矩阵
//        int n = triangle.size();
//        // 状态来自 up 和 leftUp
//        int[] dp = new int[n];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = triangle.get(0).get(0);
//        for (int i = 1; i < n; i++) {
//            int leftUp = dp[0];
//            dp[0] += triangle.get(i).get(0);
//            for (int j = 1; j <= i; j++) {
//                int tmp = dp[j];
//                dp[j] = Math.min(leftUp, dp[j - 1]) + triangle.get(i).get(j);
//                leftUp = tmp;
//            }
//        }
//
//        int result = Integer.MAX_VALUE;
//        for (int j = 0; j < n; j++) {
//            result = Math.min(result, dp[j]);
//        }
//        return result;
//    }
//}
import java.util.List;

//class Solution {
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int n = triangle.size();
//        int[] dp = new int[n];
//        dp[0] = triangle.get(0).get(0);
//
//        for (int i = 1; i < n; i++) {
//            // 处理每一行的最后一个元素
//            dp[i] = dp[i - 1] + triangle.get(i).get(i);
//
//            for (int j = i - 1; j > 0; j--) {
//                dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
//            }
//
//            // 处理每一行的第一个元素
//            dp[0] += triangle.get(i).get(0);
//        }
//
//        int minTotal = dp[0];
//        for (int j = 1; j < n; j++) {
//            minTotal = Math.min(minTotal, dp[j]);
//        }
//
//        return minTotal;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
