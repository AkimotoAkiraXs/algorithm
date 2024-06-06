// You are given a m x n matrix grid consisting of non-negative integers where
// grid[row][col] represents the minimum time required to be able to visit the cell (
// row, col), which means you can visit the cell (row, col) only when the time you
// visit it is greater than or equal to grid[row][col].
//
// You are standing in the top-left cell of the matrix in the 0ᵗʰ second, and 
// you must move to any adjacent cell in the four directions: up, down, left, and
// right. Each move you make takes 1 second.
//
// Return the minimum time required in which you can visit the bottom-right 
// cell of the matrix. If you cannot visit the bottom-right cell, then return -1.
//
// 
// Example 1: 
//
// 
//
// 
// Input: grid = [[0,1,3,2],[5,1,2,5],[4,3,8,6]]
// Output: 7
// Explanation: One of the paths that we can take is the following:
//- at t = 0, we are on the cell (0,0).
//- at t = 1, we move to the cell (0,1). It is possible because grid[0][1] <= 1.
//
//- at t = 2, we move to the cell (1,1). It is possible because grid[1][1] <= 2.
//
//- at t = 3, we move to the cell (1,2). It is possible because grid[1][2] <= 3.
//
//- at t = 4, we move to the cell (1,1). It is possible because grid[1][1] <= 4.
//
//- at t = 5, we move to the cell (1,2). It is possible because grid[1][2] <= 5.
//
//- at t = 6, we move to the cell (1,3). It is possible because grid[1][3] <= 6.
//
//- at t = 7, we move to the cell (2,3). It is possible because grid[2][3] <= 7.
//
// The final time is 7. It can be shown that it is the minimum time possible.
// 
//
// Example 2: 
//
// 
//
// 
// Input: grid = [[0,2,4],[3,2,1],[1,0,4]]
// Output: -1
// Explanation: There is no path from the top left to the bottom-right cell.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 1000 
// 4 <= m * n <= 10⁵ 
// 0 <= grid[i][j] <= 10⁵ 
// grid[0][0] == 0 
// 
//
// 
// 
//
// 👍 39 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeSet;

/**
 * Id：&emsp;&emsp;2577
 * <p>
 * Name：Minimum Time to Visit a Cell In a Grid
 *
 * @author Yuri
 * @since 2024-06-06 11:39:29
 */

public class MinimumTimeToVisitACellInAGrid {

    public static void main(String[] args) {
        Solution solution = new MinimumTimeToVisitACellInAGrid().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        /**
         * 只要能移动一格则可以来回跳动来到达某个位置，bfs+优先队列计算到达每个位置最小时间
         * <p>
         * 注意1：在进行方向判断算某一格最小时间的时候不要直接修改v，粗心！
         * 注意2：判断是否能移动不能用原位置是否为(0,0)，因为(0,1)被堵住时也可以通过在(1,0)来回移动来增加时间。
         */
        public int minimumTime(int[][] grid) {
            if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
            int m = grid.length, n = grid[0].length;
            TreeSet<int[]> queue = new TreeSet<>((a, b) -> {
                for (int i = 2; i >= 0; i--)
                    if (a[i] != b[i]) return a[i] - b[i];
                return 0;
            });
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            queue.add(new int[]{0, 0, 1});
            boolean[][] vis = new boolean[m][n];
            vis[0][0] = true;
            while (true) {
                int[] q = queue.pollFirst();
                int x = q[0], y = q[1], v = q[2];
                for (int[] d : dir) {
                    int a = x + d[0], b = y + d[1], k = v;
                    if (a < 0 || a >= m || b < 0 || b >= n || vis[a][b]) continue;
                    if (grid[a][b] > k) k = grid[a][b] + (grid[a][b] - k) % 2;
                    if (a == m - 1 && b == n - 1) return k;
                    queue.add(new int[]{a, b, k + 1});
                    vis[a][b] = true;
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}