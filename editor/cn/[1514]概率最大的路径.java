import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static class Node {
        int vertex;
        double distance;

        public Node(int vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public double maxProbability(int n, int[][] Nodes, double[] succProb, int start_node, int end_node) {
        // 建图是为了获取一个顶点的相邻顶点
        List<Node>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < Nodes.length; i++) {
            graph[Nodes[i][0]].add(new Node(Nodes[i][1], succProb[i]));
            // 无向图
            graph[Nodes[i][1]].add(new Node(Nodes[i][0], succProb[i]));
        }
        double[] dist = new double[n];
        // 从算法定义上来说是finished而不是visited
        boolean[] finished = new boolean[n];
        // PriorityQueue的默认比较器compare方法是返回int类型的，需要使用Double.compare()返回比较结果，不然0.9的double结果可能被强制转化成0
        // Node (v, dist[v])
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));

        // 用来求最大路径
        Arrays.fill(dist, Double.MIN_VALUE);
        dist[start_node] = 1;
        pq.offer(new Node(start_node, 1));

        // dijkstra
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            // 剪枝
            if (curr.vertex == end_node) {
                break;
            }
            if (finished[curr.vertex]) {
                continue;
            }
            int v = curr.vertex;
            double distance = curr.distance;
            finished[v] = true;
            for (Node next : graph[v]) {
                // 概率应该相乘而不是相加
                double newDistance = dist[v] * next.distance;
                if (newDistance > dist[next.vertex]) {
                    dist[next.vertex] = newDistance;
                    pq.offer(new Node(next.vertex, newDistance));
                }
            }
        }

        return dist[end_node] == Double.MIN_VALUE ? 0 : dist[end_node];
    }


}


//leetcode submit region end(Prohibit modification and deletion)
