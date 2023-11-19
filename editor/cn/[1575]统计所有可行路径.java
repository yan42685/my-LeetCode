
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
                int consumption = Math.abs(locations[start] - locations[i]);
                count = (count + dfs(locations, i, finish, fuel - consumption)) % ((int) 1e9 + 7);
            }
        }
        memo[start][fuel] = count;
        return count;
    }
}

//public class Solution {
//    private static final int MOD = (int) 1e9 + 7;
//    // 缓存dfs结果
//    private int[][] memo;
//
//    public int countRoutes(int[] locations, int start, int finish, int fuel) {
//        memo = new int[locations.length][fuel + 1];
//        for (int[] row : memo) {
//            Arrays.fill(row, -1);
//        }
//        return dfs(locations, start, finish, fuel);
//    }
//
//    private int dfs(int[] locations, int current, int finish, int fuel) {
//        if (fuel < 0) {
//            return 0;
//        }
//        if (memo[current][fuel] != -1) {
//            return memo[current][fuel];
//        }
//        // 不消耗燃料到终点的路径数
//        int count = current == finish ? 1 : 0;
//        for (int i = 0; i < locations.length; i++) {
//            if (i != current) {
//                count = (count + dfs(locations, i, finish, fuel - Math.abs(locations[current] - locations[i]))) % MOD;
//            }
//        }
//        memo[current][fuel] = count;
//        return count;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
