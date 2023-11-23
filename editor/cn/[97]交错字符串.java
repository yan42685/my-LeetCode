
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m  = s1.length();
        int n = s2.length();
        
        int[][] dp = new int[][]
    }
}
/**
 * 一次性写对的关键在于dp定义准确
 * <p>
 * 状态压缩, 只有根据二维dp修改才好写，不必第一次就写出来
 */
//class Solution {
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s1.length() + s2.length() != s3.length()) {
//            return false;
//        }
//        // dp[i][j]表示s1前i-1个字符和s2前j-1个字符能否交错构成s3前i+j-2个字符  (从0开始数)
//        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
//        dp[0][0] = true;
//        for (int i = 1; i <= s1.length() && dp[i - 1][0]; i++) {
//            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1);
//        }
//        for (int j = 1; j <= s2.length() && dp[0][j - 1]; j++) {
//            dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1);
//        }
//        for (int i = 1; i <= s1.length(); i++) {
//            for (int j = 1; j <= s2.length(); j++) {
//                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
//                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
//            }
//        }
//        return dp[s1.length()][s2.length()];
//    }
//}


/**
 * 状态压缩, 只有根据二维dp修改才好写，不必第一次就写出来
 */
//class Solution {
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s1.length() + s2.length() != s3.length()) {
//            return false;
//        }
//        boolean[] dp = new boolean[s2.length() + 1];
//        dp[0] = true;
//        for (int j = 1; j <= s2.length() && dp[j - 1]; j++) {
//            dp[j] = s2.charAt(j - 1) == s3.charAt(j - 1);
//        }
//        for (int i = 1; i <= s1.length(); i++) {
//            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
//            for (int j = 1; j <= s2.length(); j++) {
//                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
//                        || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
//            }
//        }
//        return dp[s2.length()];
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
