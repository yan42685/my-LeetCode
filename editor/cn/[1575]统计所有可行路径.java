
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long result = dfs(locations, start, finish, fuel);
        return (int) (result % (1e9 + 7));
    }

    private long dfs(int[] locations, int start, int finish, int fuel) {
        int consumption = Math.abs(locations[start] - locations[finish]);
        if (fuel < consumption) {
            return 0L;
        }
        long result = 1;
        for (int i = 0; i < locations.length; i++) {
            if (i != start) {
                
                result += dfs(locations, start, i, fuel) +
                        dfs(locations, i, finish, fuel - Math.abs(locations[start] - locations[i]));
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
