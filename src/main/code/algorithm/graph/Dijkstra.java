package algorithm.graph;

import java.util.*;

/**
 * 迪杰斯特拉，
 * <p>
 * 用于求解图中某个点到其余点的最短距离
 * <p>
 * 思路：将点分为A、B俩堆（分别记录点的ID和距离，A中记录的距离便是最小距离，B中记录的距离为当前找到的最小距离）初始A为空，B包含所有点。
 * 遍历A中点的每条相邻边，更新B中点的最小距离，然后从B中选择一个距离最小的点加入A，重复。
 *
 * @author Yuri
 * @see <a href="https://leetcode.cn/problems/network-delay-time/solutions/2668220/liang-chong-dijkstra-xie-fa-fu-ti-dan-py-ooe8/">Dijkstra 算法介绍</a>
 * @see Floyd 弗洛伊德
 * @since 2024/4/16 17:51
 */


public class Dijkstra {

    /**
     * 普通做法O(n^2)，适用于稠密图
     */
    public int networkDelayTime_dense(int[][] times, int n, int p) {
        final int INF = Integer.MAX_VALUE / 2; // 防止加法溢出
        int[][] g = new int[n + 1][n + 1]; // 邻接矩阵
        for (int[] t : times) g[t[0]][t[1]] = t[2];
        int maxDis = 0;
        int[] dis = new int[n + 1];
        Arrays.fill(dis, INF);
        dis[p] = 0;
        boolean[] done = new boolean[n + 1]; // 记录哪些点已经被用于计算
        while (true) {
            int x = -1;
            for (int i = 1; i <= n; i++)
                if (!done[i] && (x < 0 || dis[i] < dis[x])) x = i; // 选择一个最小的点作为下一次计算
            if (x < 0) return maxDis;
            if (dis[x] == INF) return -1;// 有节点无法到达
            maxDis = Math.max(maxDis, dis[x]);
            done[x] = true; // 最短路长度已确定（无法变得更小）
            for (int y = 1; y <= n; y++) dis[y] = Math.min(dis[y], dis[x] + g[x][y]);// 更新 x 的邻居的最短路
        }
    }

    /**
     * 大小堆优化做法O(eloge)，e是边的数量，不适用于稠密图
     */
    public int dijkstra_spase(int[][] times, int n, int k) {
        List<int[]>[] maps = new ArrayList[n + 1];
        Arrays.setAll(maps, m -> new ArrayList<>());
        for (int[] time : times) maps[time[0]].add(new int[]{time[1], time[2]});
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;
        int ans = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[]{k, 0});
        int left = n;
        while (!queue.isEmpty() && left > 0) {
            int[] p = queue.poll();
            int i = p[0];
            int v = p[1];
            if (v > dis[i]) continue;
            left--;
            ans = Math.max(ans, v);
            for (int[] m : maps[i]) {
                int j = m[0];
                int d = m[1] + v;
                if (d < dis[j]) {
                    dis[j] = d;
                    queue.add(new int[]{j, dis[j]});
                }
            }
        }
        return left == 0 ? ans : -1;
    }
}
