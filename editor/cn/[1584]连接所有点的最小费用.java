import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Kruskal算法
 */
class Solution {
    public int minCostConnectPoints(int[][] points) {
        // edge保存 x,y,distance, 按距离从小到大排序
        // 不能用TreeSet, 因为相同长度的边无法被添加
        Queue<int[]> edges = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        // 添加所有可能的边
        // 只用添加点A到点B的距离，不必再添加点B到点A的，想象一个 n x n 矩阵用主对角线划分两部分
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                // 用索引表示对应的point, 将二维坐标映射到一维
                edges.offer(new int[]{i, j, getDistance(points[i], points[j])});
            }
        }

        int result = 0;
        UnionFind uf = new UnionFind(points.length);
        while (!edges.isEmpty() && uf.getCount() > 1) {
            int[] edge = edges.poll();
            // 添加边之前要确认两个点不在同一连通分量里
            if (!uf.isConnected(edge[0], edge[1])) {
                uf.union(edge[0], edge[1]);
                result += edge[2];
            }
        }
        return result;
    }
    private int getDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    private static class UnionFind {
        int[] parent;
        // 连通分量数
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            if (rootA != rootB) {
                parent[rootA] = rootB;
                --count;
            }
        }

        public int findRoot(int a) {
            if (parent[a] == a) {
                return a;
            } else {
                parent[a] = findRoot(parent[a]);
                return parent[a];
            }
        }

        public boolean isConnected(int a, int b) {
            return findRoot(a) == findRoot(b);
        }

        public int getCount() {
            return count;
        }
    }
}

/**
 * Prim算法
 */
//class Solution {
//    public int minCostConnectPoints(int[][] points) {
//        boolean[] visited = new boolean[points.length];
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
//
//        int result = 0;
//        int count = 1;
//        visited[0] = true;
//        // 添加顶点0的相邻点
//        for (int i = 1; i < points.length; i++) {
//            pq.offer(new int[]{i, getDistance(points[0], points[i])});
//        }
//
//        while (!pq.isEmpty() && count < points.length) {
//            int[] curr = pq.poll();
//            int vertex = curr[0];
//            if (visited[vertex]) {
//                continue;
//            }
//            // 如果当前点没有被访问过
//            result += curr[1];
//            ++count;
//            visited[vertex] = true;
//            // 完全图所有点都是相邻点
//            for (int i = 1; i < points.length; i++) {
//                // 只添加未被访问的点
//                if (!visited[i]) {
//                    pq.offer(new int[]{i, getDistance(points[vertex], points[i])});
//                }
//            }
//        }
//        return result;
//
//    }
//
//    private int getDistance(int[] point1, int[] point2) {
//        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
//    }
//}

//leetcode submit region end(Prohibit modification and deletion)
