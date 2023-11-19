
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {

    }

    private long dfs(int[] locations, int start, int finish, int fuel) {
        if (fuel < Math.abs(locations[start] - locations[finish])) {
            return 0L;
        }
        long result = 1;
        for (int location : locations) {
            if (location != finish) {
                result += dfs(locations, location, finish, fuel - Math.abs(location - finish));
            }
        }
        return reuslt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
