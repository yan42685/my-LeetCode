import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        // 用LinkedList类型是为了方便用offerLast, pollLast
        LinkedList<Integer> path = new LinkedList<>();
        dfs(graph, result, path, 0);
        return result;
    }

    private void dfs(int[][] graph, List<List<Integer>> result, LinkedList<Integer> path,
                     int curr) {
        path.offerLast(curr);
        if (curr == graph.length - 1) {
            result.add(new LinkedList<>(path));  // 用clone会返回Object类型
        }
        for (int next : graph[curr]) {
            dfs(graph, result, path, next);
        }
        path.pollLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
