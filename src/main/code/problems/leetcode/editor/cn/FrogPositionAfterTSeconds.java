// Given an undirected tree consisting of n vertices numbered from 1 to n. A
// frog starts jumping from vertex 1. In one second, the frog jumps from its current
// vertex to another unvisited vertex if they are directly connected. The frog can
// not jump back to a visited vertex. In case the frog can jump to several vertices,
// it jumps randomly to one of them with the same probability. Otherwise, when the
// frog can not jump to any unvisited vertex, it jumps forever on the same vertex.
//
//
// The edges of the undirected tree are given in the array edges, where edges[i]
// = [ai, bi] means that exists an edge connecting the vertices ai and bi. 
//
// Return the probability that after t seconds the frog is on the vertex target.
// Answers within 10⁻⁵ of the actual answer will be accepted. 
//
// 
// Example 1: 
// 
// 
// Input: n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
//
// Output: 0.16666666666666666
// Explanation: The figure above shows the given graph. The frog starts at
// vertex 1, jumping with 1/3 probability to the vertex 2 after second 1 and then
// jumping with 1/2 probability to vertex 4 after second 2. Thus the probability for the
// frog is on the vertex 4 after 2 seconds is 1/3 * 1/2 = 1/6 = 0.16666666666666666.
// 
// 
//
// Example 2: 
//
//
// 
// Input: n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
//
// Output: 0.3333333333333333
// Explanation: The figure above shows the given graph. The frog starts at
// vertex 1, jumping with 1/3 = 0.3333333333333333 probability to the vertex 7 after
// second 1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 100 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ai, bi <= n 
// 1 <= t <= 50 
// 1 <= target <= n 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 图 👍 88 👎 0

package problems.leetcode.editor.cn;

import java.util.*;

/**
 * Id：&emsp;&emsp;1377
 * <p>
 * Name：Frog Position After T Seconds
 *
 * @author Yuri
 * @since 2023-05-24 16:37:56
 */


public class FrogPositionAfterTSeconds {
    public static void main(String[] args) {
        Solution solution = new FrogPositionAfterTSeconds().new Solution();
        double v = solution.frogPosition(7, new int[][]{{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}}, 2, 4);
        System.out.println(v);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 使用邻接表记录每个点的入度和出度，再利用深搜和标记记录从开始点1到目标点的路径
         * <p>
         * 最后，遍历路劲，ans *= 1/每个路劲点的出度，根据题意：除开始点node1以外每个点入度都是1，所以出度就是邻接表size-1
         * <p>
         * tips:dfs找到路劲后给node1邻接表加一个入度节点可以避免后续特殊处理node1
         */
        private List<List<Integer>> path = new ArrayList<>(); // 邻接表
        private Deque<Integer> record = new LinkedList<>(); // 1到target路劲记录
        private int target;
        boolean[] vis; // 标记遍历过得点

        public double frogPosition(int n, int[][] edges, int t, int target) {
            this.target = target;
            vis = new boolean[n + 1];
            for (int i = 0; i <= n; i++) path.add(new ArrayList<>());
            for (int[] edge : edges) {
                path.get(edge[0]).add(edge[1]);
                path.get(edge[1]).add(edge[0]);
            }
            dfs(1);
            // 等dfs搜索路劲结束后，给node1的path加一个入度点
            path.get(1).add(0);
            if (record.size() - 1 == t || (record.size() - 1 < t && path.get(target).size() - 1 == 0)) {
                double res = 1;
                while (record.size() > 1) res *= (double) 1 / (path.get(record.removeFirst()).size() - 1);
                return res;
            }
            return 0.00000;
        }


        private boolean dfs(int k) {
            vis[k] = true;
            record.addLast(k);
            if (k == target) return true;
            List<Integer> edge = path.get(k);
            for (Integer next : edge) {
                if (!vis[next]) {
                    if (dfs(next)) return true;
                    record.removeLast();
                }
            }
            return false;
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

} 
