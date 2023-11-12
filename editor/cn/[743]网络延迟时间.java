import com.sun.scenario.effect.light.DistantLight;

import java.util.ArrayList;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 邻接表
 * 这段代码没有问题，跑得没有邻接矩阵快，是因为测试数据大多是稠密图
 */
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 建图是为了获取一个顶点的相邻顶点
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] triple : times) {
            // v1 : [v2, distance]
            graph[triple[0]].add(new int[]{triple[1], triple[2]});
        }
        int[] dist = new int[n + 1];
        boolean[] finished = new boolean[n + 1];
        // 多个候选顶点，取出到原点距离最短的顶点 [v, dist[v]]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        Arrays.fill(dist, Integer.MAX_VALUE);
        // 原点最短
        dist[k] = 0;
        pq.offer(new int[]{k, dist[k]});

        // dijkstra
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (finished[curr[0]]) {
                continue;
            }
            finished[curr[0]] = true;

            for (int[] next : graph[curr[0]]) {
                int newDistance = dist[curr[0]] + next[1];
                if (newDistance < dist[next[0]]) {
                    dist[next[0]] = newDistance;
                    pq.offer(new int[]{next[0], newDistance});
                }
            }
        }
        
        int maxdistance = Arrays.stream(dist).skip(1).max().getAsInt();
        return maxdistance == Integer.MAX_VALUE ? -1 : maxdistance;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
