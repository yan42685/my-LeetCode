import java.util.LinkedList;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<Node> list = new LinkedList<>();
    private static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // 每个相邻节点都可以计算出来，所以就不用构建图了

        // 标记状态，将二维坐标映射为一维数字
        int[] dist = new int[m * n];
        boolean[] finished = new boolean[m * n];
        // 不要直接相减，因为可能溢出
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.offer(new Node(0, 0, dist[0]));

        // dijkstra
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int vertex = x * n + y;
            // 剪枝
            if (vertex == m * n - 1) {
                break;
            }
            if (finished[vertex]) {
                continue;
            }
            finished[vertex] = true;
            for (Node next : getNeighbors(heights, curr)) {
                // 即使已经visited[nextVertex]也不能跳过，因为其他路径可能经过这个节点
                int nextVertex = next.x * n + next.y;
                int newDistance = Math.max(dist[vertex], Math.abs(heights[x][y] - heights[next.x][next.y]));
                if (newDistance < dist[nextVertex]) {
                    dist[nextVertex] = newDistance;
                    pq.offer(new Node(next.x, next.y, newDistance));
                }
            }
        }

        // 不是m * n而是 m * n -1
        return dist[m * n -1];
    }

    private List<Node> getNeighbors(int[][] heights, Node node) {
        List<Node> result = new LinkedList<>();
        int x = node.x;
        int y = node.y;
        if (x - 1 >= 0) {
            result.add(new Node(x - 1, y, heights[x - 1][y]));
        }
        if (x + 1 <= heights.length - 1) {
            result.add(new Node(x + 1, y, heights[x + 1][y]));
        }
        if (y - 1 >= 0) {
            result.add(new Node(x, y - 1, heights[x][y - 1]));
        }
        if (y + 1 <= heights[0].length - 1) {
            result.add(new Node(x, y + 1, heights[x][y + 1]));
        }
        return result;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
