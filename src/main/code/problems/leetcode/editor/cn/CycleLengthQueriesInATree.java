// You are given an integer n. There is a complete binary tree with 2ⁿ - 1 nodes.
// The root of that tree is the node with the value 1, and every node with a 
// value val in the range [1, 2n - 1 - 1] has two children where:
//
// 
// The left node has the value 2 * val, and 
// The right node has the value 2 * val + 1. 
// 
//
// You are also given a 2D integer array queries of length m, where queries[i] =
// [ai, bi]. For each query, solve the following problem: 
//
// 
// Add an edge between the nodes with values ai and bi. 
// Find the length of the cycle in the graph. 
// Remove the added edge between nodes with values ai and bi. 
// 
//
// Note that: 
//
// 
// A cycle is a path that starts and ends at the same node, and each edge in 
// the path is visited only once.
// The length of a cycle is the number of edges visited in the cycle. 
// There could be multiple edges between two nodes in the tree after adding the 
// edge of the query.
// 
//
// Return an array answer of length m where answer[i] is the answer to the iᵗʰ 
// query.
//
// 
// Example 1: 
// 
// 
// Input: n = 3, queries = [[5,3],[4,7],[2,3]]
// Output: [4,5,3]
// Explanation: The diagrams above show the tree of 2³ - 1 nodes. Nodes colored
// in red describe the nodes in the cycle after adding the edge.
//- After adding the edge between nodes 3 and 5, the graph contains a cycle of 
// nodes [5,2,1,3]. Thus answer to the first query is 4. We delete the added edge
// and process the next query.
//- After adding the edge between nodes 4 and 7, the graph contains a cycle of 
// nodes [4,2,1,3,7]. Thus answer to the second query is 5. We delete the added
// edge and process the next query.
//- After adding the edge between nodes 2 and 3, the graph contains a cycle of 
// nodes [2,1,3]. Thus answer to the third query is 3. We delete the added edge.
// 
//
// Example 2: 
// 
// 
// Input: n = 2, queries = [[1,2]]
// Output: [2]
// Explanation: The diagram above shows the tree of 2² - 1 nodes. Nodes colored
// in red describe the nodes in the cycle after adding the edge.
//- After adding the edge between nodes 1 and 2, the graph contains a cycle of 
// nodes [2,1]. Thus answer for the first query is 2. We delete the added edge.
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 30 
// m == queries.length 
// 1 <= m <= 10⁵ 
// queries[i].length == 2 
// 1 <= ai, bi <= 2ⁿ - 1 
// ai != bi 
// 
//
// 👍 26 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2509
 * <p>
 * Name：Cycle Length Queries in a Tree
 *
 * @author Yuri
 * @since 2024-07-30 10:51:27
 */

public class CycleLengthQueriesInATree {

    public static void main(String[] args) {
        Solution solution = new CycleLengthQueriesInATree().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * Integer.numberOfLeadingZeros(b)是求32位数中前置0的个数
         */
        public int[] cycleLengthQueries(int n, int[][] queries) {
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                int a = Math.max(queries[i][0], queries[i][1]), b = Math.min(queries[i][0], queries[i][1]);
                int d = Integer.numberOfLeadingZeros(b) - Integer.numberOfLeadingZeros(a); // d表示a比b多了多少位数，在树中也就是多了几层
                ans[i] = d + (32 - Integer.numberOfLeadingZeros((a >> d) ^ b)) * 2 + 1; // 1110和1101只需要分别上移两位就能相遇（不需要到达1）
            }
            return ans;
        }

        // 暴力
        public int[] cycleLengthQueries_bf(int n, int[][] queries) {
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int a = queries[i][0], b = queries[i][1];
                int len = 0;
                while (a != b) {
                    if (a > b) a >>= 1;
                    else b >>= 1;
                    len++;
                }
                ans[i] = len + 1;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}