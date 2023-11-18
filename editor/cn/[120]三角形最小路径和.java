
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 实际是n x n矩阵
        int n = triangle.size();
        int[] dp = new int[n];
        // 作为边界条件
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            int leftUp = dp[0];
            dp[0] += triangle.get(i).get(0);
            for (int j = 1; j <= i; j++) {
                int tmp = dp[j];
                // 状态来自 up 和 leftUp
                dp[j] = Math.min(leftUp, dp[j]) + triangle.get(i).get(j);
                leftUp = tmp;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            result = Math.min(result, dp[j]);
        }
        return result;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
