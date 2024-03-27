// You are given a network of n nodes, labeled from 1 to n. You are also given
// times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui
// is the source node, vi is the target node, and wi is the time it takes for a
// signal to travel from source to target.
//
// We will send a signal from a given node k. Return the minimum time it takes 
// for all the n nodes to receive the signal. If it is impossible for all the n
// nodes to receive the signal, return -1.
//
// 
// Example 1: 
// 
// 
// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
// Output: 2
// 
//
// Example 2: 
//
// 
// Input: times = [[1,2,1]], n = 2, k = 1
// Output: 1
// 
//
// Example 3: 
//
// 
// Input: times = [[1,2,1]], n = 2, k = 2
// Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.) 
// 
//
// 👍 727 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Id：&emsp;&emsp;743
 * <p>
 * Name：Network Delay Time
 *
 * @author Yuri
 * @since 2024-03-27 16:07:39
 */

public class NetworkDelayTime {

    public static void main(String[] args) {
        Solution solution = new NetworkDelayTime().new Solution();
        System.out.println(solution.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }

    // [[2,1,1],[2,3,1],[3,4,1]]
//     4
//     2
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // dijkstra 普通做法。O(n^2)，适合与稠密图
        public int networkDelayTime_dense(int[][] times, int n, int k) {
            final int INF = Integer.MAX_VALUE / 2; // 防止加法溢出
            int[][] g = new int[n + 1][n + 1]; // 邻接矩阵
            for (int[] t : times) g[t[0]][t[1]] = t[2];
            int maxDis = 0;
            int[] dis = new int[n + 1];
            Arrays.fill(dis, INF);
            dis[k] = 0;
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

        // 大小堆优化做法O(mlogm)，m是times的长度，不适用与稠密图
        public int networkDelayTime(int[][] times, int n, int k) {
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
// leetcode submit region end(Prohibit modification and deletion)

}