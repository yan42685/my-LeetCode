import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean isPossible;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] pair : dislikes) {
            graph[pair[0]].add(pair[1]);
            graph[pair[1]].add(pair[0]);
        }
        boolean[] visited = new boolean[n + 1];
        boolean[] colors = new boolean[n + 1];
        isPossible = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, colors, i);
                if (!isPossible) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(List<Integer>[] graph, boolean[] visited, boolean[] colors, int curr) {
        if (!isPossible) {
            return;
        }
        visited[curr] = true;
        for (int next : graph[curr]) {
            if (visited[next]) {
                if (colors[next] == colors[curr]) {
                    isPossible = false;
                    return;
                }
            } else {
                colors[next] = !colors[curr];
                dfs(graph, visited, colors, next);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
