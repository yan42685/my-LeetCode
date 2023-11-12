
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean isBipartite;

    public boolean isBipartite(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] colors = new boolean[graph.length];
        isBipartite = true;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(graph, visited, colors, i);
            }
            if (!isBipartite) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int[][] graph, boolean[] visited, boolean[] color, int curr) {
        if (!isBipartite) {
            return;
        }
        visited[curr] = true;
        for (int next : graph[curr]) {
            if (visited[next]) {
                if (color[next] == color[curr]) {
                    isBipartite = false;
                    return;
                }
            } else {
                color[next] = !color[curr];
                dfs(graph, visited, color, next);
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
