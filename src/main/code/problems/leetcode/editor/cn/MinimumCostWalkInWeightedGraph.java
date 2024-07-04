// There is an undirected weighted graph with n vertices labeled from 0 to n - 1.
// 
//
// You are given the integer n and an array edges, where edges[i] = [ui, vi, wi]
// indicates that there is an edge between vertices ui and vi with a weight of wi.
// 
//
// A walk on a graph is a sequence of vertices and edges. The walk starts and 
// ends with a vertex, and each edge connects the vertex that comes before it and
// the vertex that comes after it. It's important to note that a walk may visit the
// same edge or vertex more than once.
//
// The cost of a walk starting at node u and ending at node v is defined as the 
// bitwise AND of the weights of the edges traversed during the walk. In other
// words, if the sequence of edge weights encountered during the walk is w0, w1, w2, ..
//., wk, then the cost is calculated as w0 & w1 & w2 & ... & wk, where & denotes 
// the bitwise AND operator.
//
// You are also given a 2D array query, where query[i] = [si, ti]. For each 
// query, you need to find the minimum cost of the walk starting at vertex si and
// ending at vertex ti. If there exists no such walk, the answer is -1.
//
// Return the array answer, where answer[i] denotes the minimum cost of a walk 
// for query i.
//
// 
// Example 1: 
//
// 
// Input: n = 5, edges = [[0,1,7],[1,3,7],[1,2,1]], query = [[0,3],[3,4]] 
// 
//
// Output: [1,-1] 
//
// Explanation: 
// 
// To achieve the cost of 1 in the first query, we need to move on the 
// following edges: 0->1 (weight 7), 1->2 (weight 1), 2->1 (weight 1), 1->3 (weight 7).
//
// In the second query, there is no walk between nodes 3 and 4, so the answer 
// is -1.
//
// Example 2: 
//
// 
// Input: n = 3, edges = [[0,2,7],[0,1,15],[1,2,6],[1,2,1]], query = [[1,2]] 
// 
//
// Output: [0] 
//
// Explanation: 
// 
// To achieve the cost of 0 in the first query, we need to move on the 
// following edges: 1->2 (weight 1), 2->1 (weight 6), 1->2 (weight 1).
//
// 
// Constraints: 
//
// 
// 2 <= n <= 10⁵ 
// 0 <= edges.length <= 10⁵ 
// edges[i].length == 3 
// 0 <= ui, vi <= n - 1 
// ui != vi 
// 0 <= wi <= 10⁵ 
// 1 <= query.length <= 10⁵ 
// query[i].length == 2 
// 0 <= si, ti <= n - 1 
// si != ti 
// 
//
// 👍 11 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;3108
 * <p>
 * Name：Minimum Cost Walk in Weighted Graph
 *
 * @author Yuri
 * @since 2024-07-04 14:49:26
 */

public class MinimumCostWalkInWeightedGraph {

    public static void main(String[] args) {
        Solution solution = new MinimumCostWalkInWeightedGraph().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 贪心：既然边可以重复走，代价又是与值（只可能越来越小），所以最小代价就是把能走的边都走一遍，并查集判断是否相连
     */
    class Solution {

        int[] p;
        int[] ad;

        public int[] minimumCost(int n, int[][] edges, int[][] query) {
            p = new int[n];
            ad = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
            Arrays.fill(ad, Integer.MAX_VALUE);
            for (int[] edge : edges) union(edge[0], edge[1], edge[2]);
            return Arrays.stream(query).map(q -> {
                int x = q[0], y = q[1];
                if (find(x) != find(y)) return -1;
                return ad[find(x)];
            }).mapToInt(i -> i).toArray();
        }

        int find(int k) {
            if (k != p[k]) p[k] = find(p[k]);
            return p[k];
        }

        void union(int a, int b, int val) {
            int x = find(a), y = find(b);
            if (x != y) p[x] = p[y];
            ad[y] &= ad[x] & val;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}