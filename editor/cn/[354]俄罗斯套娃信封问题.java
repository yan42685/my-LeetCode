
//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;

/**
 * 二分 + 贪心
 * 如果可以旋转，就在按宽度排序前，预先旋转一遍，让所有信封宽度 > 高度，保证形状一样
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // 先按宽度升序，如果宽度相同则按高度降序，表示相同宽度的信封不能嵌套
        // 排序完成之后可以保证，只要按高度是Longest Increasing
        Arrays.sort(envelopes, (a, b) ->
                a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        List<Integer> list = new ArrayList<>();
        for (int[] envelop : envelopes) {
            int i = lowerBound(list, envelop[1]);
            if (i == list.size()) {
                list.add(envelop[1]);
            } else {
                list.set(i, envelop[1]);
            }
        }
        return list.size();
    }

    private int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}


/**
 * DP 超时
 * 核心思路：最长套娃序列一定是按宽度、高度排序之后的子序列
 */
//class Solution {
//    public int maxEnvelopes(int[][] envelopes) {
//        // 如果宽度不同则按宽度升序，相同则按高度降序
//        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
//        int[] dp = new int[envelopes.length];
//        Arrays.fill(dp, 1);
//        int result = 1;
//        for (int i = 1; i < envelopes.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (envelopes[i][0] != envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
//                    dp[i] = Math.max(dp[i], 1 + dp[j]);
//                }
//            }
//            result = Math.max(result, dp[i]);
//        }
//        return result;
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
