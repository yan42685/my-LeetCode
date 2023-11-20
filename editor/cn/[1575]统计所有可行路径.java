
/**
 * 没必要用动态规划，这个时间复杂度一样，并且更直观
 */
class Solution {
    private static final int MOD = (int) (1e9 + 7);
    int[][] memo;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        memo = new int[locations.length][fuel + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(locations, start, finish, fuel);
    }

    private int dfs(int[] locations, int start, int finish, int fuel) {
        if (fuel < 0) {
            return 0;
        }

        if (memo[start][fuel] != -1) {
            return memo[start][fuel];
        }

        int count = start == finish ? 1 : 0;

        for (int i = 0; i < locations.length; i++) {
            if (i != start) {
                int cost = Math.abs(locations[start] - locations[i]);
                count = (count + dfs(locations, i, finish, fuel - cost)) % MOD;
            }
        }
        memo[start][fuel] = count;
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
