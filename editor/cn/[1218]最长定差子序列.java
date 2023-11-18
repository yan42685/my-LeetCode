
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        int result = 1;
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = arr[i] - arr[i - 1] == difference ? dp[i - 1] + 1 : 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
