// You are given an m x n integer matrix grid where each cell is either 0 (empty)
// or 1 (obstacle). You can move up, down, left, or right from and to an empty 
// cell in one step.
//
// Return the minimum number of steps to walk from the upper left corner (0, 0) 
// to the lower right corner (m - 1, n - 1) given that you can eliminate at most k
// obstacles. If it is not possible to find such walk return -1.
//
// 
// Example 1: 
// 
// 
// Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
// Output: 6
// Explanation:
// The shortest path without eliminating any obstacle is 10.
// The shortest path with one obstacle elimination at position (3,2) is 6. Such
// path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
// 
//
// Example 2: 
// 
// 
// Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
// Output: -1
// Explanation: We need to eliminate at least two obstacles to find such a walk.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 40 
// 1 <= k <= m * n 
// grid[i][j] is either 0 or 1. 
// grid[0][0] == grid[m - 1][n - 1] == 0 
// 
//
// 👍 268 👎 0

package problems.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Id：&emsp;&emsp;1293
 * <p>
 * Name：Shortest Path in a Grid with Obstacles Elimination
 *
 * @author Yuri
 * @since 2024-05-29 16:04:45
 */

public class ShortestPathInAGridWithObstaclesElimination {

    public static void main(String[] args) {
        Solution solution = new ShortestPathInAGridWithObstaclesElimination().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int shortestPath(int[][] grid, int k) {
            int m = grid.length, n = grid[0].length;
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            boolean[][][] vis = new boolean[k + 1][m][n];
            Deque<int[]> deque = new LinkedList<>();
            deque.add(new int[]{0, 0, 0});
            while (!deque.isEmpty()) {
                int[] q = deque.poll();
                int pos = q[0], dis = q[1], rt = q[2];
                int i = pos / n, j = pos % n;
                if (i == m - 1 && j == n - 1) return dis;
                for (int[] d : dir) {
                    int a = i + d[0], b = j + d[1];
                    if (a < 0 || a >= m || b < 0 || b >= n || vis[rt][a][b]) continue;
                    vis[rt][a][b] = true;
                    if (grid[a][b] != 1 || rt < k) {
                        deque.add(new int[]{a * n + b, dis + 1, rt + grid[a][b]});
                    }
                }
            }
            return -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}