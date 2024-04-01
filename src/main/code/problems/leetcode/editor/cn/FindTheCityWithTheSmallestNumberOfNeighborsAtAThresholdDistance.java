// There are n cities numbered from 0 to n-1. Given the array edges where edges[
// i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between
// cities fromi and toi, and given the integer distanceThreshold.
//
// Return the city with the smallest number of cities that are reachable 
// through some path and whose distance is at most distanceThreshold, If there are
// multiple such cities, return the city with the greatest number.
//
// Notice that the distance of a path connecting cities i and j is equal to the 
// sum of the edges' weights along that path.
//
// 
// Example 1: 
// 
// 
// Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
//
// Output: 3
// Explanation: The figure above describes the graph. 
// The neighboring cities at a distanceThreshold = 4 for each city are:
// City 0 -> [City 1, City 2] 
// City 1 -> [City 0, City 2, City 3] 
// City 2 -> [City 0, City 1, City 3] 
// City 3 -> [City 1, City 2] 
// Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we
// have to return city 3 since it has the greatest number.
// 
//
// Example 2: 
// 
// 
// Input: n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]],
// distanceThreshold = 2
// Output: 0
// Explanation: The figure above describes the graph. 
// The neighboring cities at a distanceThreshold = 2 for each city are:
// City 0 -> [City 1] 
// City 1 -> [City 0, City 4] 
// City 2 -> [City 3, City 4] 
// City 3 -> [City 2, City 4]
// City 4 -> [City 1, City 2, City 3] 
// The city 0 has 1 neighboring city at a distanceThreshold = 2.
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 100 
// 1 <= edges.length <= n * (n - 1) / 2 
// edges[i].length == 3 
// 0 <= fromi < toi < n 
// 1 <= weighti, distanceThreshold <= 10^4 
// All pairs (fromi, toi) are distinct. 
// 
//
// 👍 189 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;1334
 * <p>
 * Name：Find the City With the Smallest Number of Neighbors at a Threshold Distance
 *
 * @author Yuri
 * @since 2024-03-29 14:40:10
 */

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

    public static void main(String[] args) {
        Solution solution = new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance().new Solution();
        solution.findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // Floyd
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            final int INF = Integer.MAX_VALUE / 2;
            int[][] g = new int[n][n];
            for (int[] x : g) Arrays.fill(x, INF);
            for (int[] e : edges) {
                int x = e[0], y = e[1], z = e[2];
                g[x][y] = z;
                g[y][x] = z;
            }
            // 以下维度k的空间被省略了,所以直接把g当做f使用（既完成了初始化又解约了空间）
            //            int[][] g = new int[n+1][n][n]; // g[0] 代表没有中间节点的情况
            //            f[0] = g;
            //            for (int k = 0; k < n; k++)
            //                for (int i = 0; i < n; i++)
            //                    for (int j = 0; j < n; j++)
            //                        f[k + 1][i][j] = Math.min(f[k][i][j], f[k][i][k] + f[k][k][j]);
            for (int k = 0; k < n; k++)
                for (int i = n - 1; i >= 0; i--)
                    for (int j = n - 1; j >= 0; j--)
                        g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);

            int x = 0;
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (g[i][j] <= distanceThreshold) cnt++;
                }
                if (max >= cnt) {
                    max = cnt;
                    x = i;
                }
            }
            return x;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}