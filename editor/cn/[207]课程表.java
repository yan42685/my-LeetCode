import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
// 本质是检测一个有向图是否存在环
// DFS
class Solution {
    private boolean hasCycle;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 用邻接表构建图并进行初始化
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
        }
        boolean[] path = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        hasCycle = false;

        // dfs遍历整个图
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(graph, path, visited, i);
            }
            if (hasCycle) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<Integer>[] graph, boolean[] path, boolean[] visited, int curr) {
        if (hasCycle) {
            return;
        }
        path[curr] = true;
        visited[curr] = true;
        for (int next : graph[curr]) {
            if (path[next]) {
                hasCycle = true;
                return;
            }
            if (visited[next]) {
                continue;
            }
            dfs(graph, path, visited, next);
        }
        path[curr] = false;
    }
}

// BFS
//class Solution {
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        List<Integer>[] graph = new List[numCourses];
//        for (int i = 0; i < graph.length; i++) {
//            graph[i] = new LinkedList<>();
//        }
//        int[] indegrees = new int[numCourses];
//        for (int[] pair : prerequisites) {
//            graph[pair[1]].add(pair[0]);
//            ++indegrees[pair[0]];
//        }
//        // 统计可以完成的课程数
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < indegrees.length; i++) {
//            if (indegrees[i] == 0) {
//                queue.offer(i);
//            }
//        }
//
//        int count = 0;
//        while (!queue.isEmpty()) {
//            int curr = queue.poll();
//            ++count;
//            for (int next : graph[curr]) {
//                --indegrees[next];
//                if (indegrees[next] == 0) {
//                    queue.offer(next);
//                }
//            }
//        }
//        return count == numCourses;
//
//
//    }
//}

//leetcode submit region end(Prohibit modification and deletion)
