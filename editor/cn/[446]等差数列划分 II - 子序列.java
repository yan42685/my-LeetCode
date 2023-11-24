
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        // 记录所有元素的下标，有可能有重复元素，所以，使用list
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }

        int ans = 0;

        // dp[j][i]表示以[nums[j],nums[i]]结尾的子序列的等差子序列数量
        // 这里我们可以识别到只统计长度大于等于3的子序列
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 看能不能找到nums[k]使得 nums[i]-nums[j]=nums[j]-nums[k]
                // =====>  nums[k] = 2 * nums[j] - nums[i]
                long numsK = 2L * nums[j] - nums[i];
                if (numsK > Integer.MAX_VALUE || numsK < Integer.MIN_VALUE) {
                    continue;
                }

                // 能找到这样的k，说明可以缓存三元组，找不到说明不会组成三元组
                // 正好题目要求的也是最低长度为3
                if (map.containsKey((int)numsK)) {
                    List<Integer> list = map.get((int) numsK);
                    for (Integer k : list) {
                        if (k < j) {
                            // 如果有多个k，需要累加，比如[7,7,7,7,7]这种用例
                            dp[j][i] += dp[k][j] + 1;
                        } else {
                            // 超过j了就不用往后遍历了
                            break;
                        }
                    }
                }

                ans += dp[j][i];
            }
        }

        return ans;
    }
}



//leetcode submit region end(Prohibit modification and deletion)
