import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
// 拓扑排序：(1）优先用BFS，再提一下 DFS 逆后序是正确的 1-2-3   4-5-3 后序的顺序是 3-2-1-5-4  逆过来就是正确的
// BFS
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        int[] indegrees = new int[numCourses];
        for (int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
            ++indegrees[pair[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            for (int next : graph[curr]) {
                --indegrees[next];
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (result.size() == numCourses) {
//            int[] res = new int[numCourses];
//            for (int i = 0; i < result.size(); i++) {
//                res[i] = result.get(i);
//            }
//            return res;
            return result.stream().mapToInt(x -> x).toArray();
        } else {
            return new int[]{};
        }
    }
}

// DFS
//class Solution {
//    private Deque<Integer> stack;
//    private boolean hasCycle;
//
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        List<Integer>[] graph = new List[numCourses];
//        for (int i = 0; i < graph.length; i++) {
//            graph[i] = new LinkedList<>();
//        }
//        for (int[] pair : prerequisites) {
//            graph[pair[1]].add(pair[0]);
//        }
//        boolean[] path = new boolean[numCourses];
//        boolean[] visited = new boolean[numCourses];
//        stack = new LinkedList<>();
//        hasCycle = false;
//
//        // 有环则无法拓扑排序
//        for (int i = 0; i < numCourses; i++) {
//            dfs(graph, path, visited, i);
//            if (hasCycle) {
//                return new int[]{};
//            }
//        }
//
//        int[] result = new int[numCourses];
//        for (int i = 0; i < result.length; i ++) {
//            result[i] = stack.pollLast();
//        }
//        return  result;
//    }
//
//    private void dfs(List<Integer>[] graph, boolean[] path, boolean[] visited, int curr) {
//        if (path[curr]) {
//            hasCycle = true;
//            return;
//        }
//        if (visited[curr] || hasCycle) {
//            return;
//        }
//        path[curr] = true;
//        visited[curr] = true;
//        for (int next : graph[curr]) {
//            dfs(graph, path, visited, next);
//        }
//        stack.offerLast(curr);
//        path[curr] = false;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
