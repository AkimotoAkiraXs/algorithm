// You are given a 0-indexed 2D integer array grid of size m x n which
// represents a field. Each cell has one of three values:
//
// 
// 0 represents grass, 
// 1 represents fire, 
// 2 represents a wall that you and fire cannot pass through. 
// 
//
// You are situated in the top-left cell, (0, 0), and you want to travel to the 
// safehouse at the bottom-right cell, (m - 1, n - 1). Every minute, you may move
// to an adjacent grass cell. After your move, every fire cell will spread to all
// adjacent cells that are not walls.
//
// Return the maximum number of minutes that you can stay in your initial 
// position before moving while still safely reaching the safehouse. If this is
// impossible, return -1. If you can always reach the safehouse regardless of the minutes
// stayed, return 10⁹.
//
// Note that even if the fire spreads to the safehouse immediately after you 
// have reached it, it will be counted as safely reaching the safehouse.
//
// A cell is adjacent to another cell if the former is directly north, east, 
// south, or west of the latter (i.e., their sides are touching).
//
// 
// Example 1: 
// 
// 
// Input: grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2]
//,[0,0,0,0,0,0,0]]
// Output: 3
// Explanation: The figure above shows the scenario where you stay in the
// initial position for 3 minutes.
// You will still be able to safely reach the safehouse.
// Staying for more than 3 minutes will not allow you to safely reach the
// safehouse.
//
// Example 2: 
// 
// 
// Input: grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
// Output: -1
// Explanation: The figure above shows the scenario where you immediately move
// towards the safehouse.
// Fire will spread to any cell you move towards and it is impossible to safely
// reach the safehouse.
// Thus, -1 is returned.
// 
//
// Example 3: 
// 
// 
// Input: grid = [[0,0,0],[2,2,0],[1,2,0]]
// Output: 1000000000
// Explanation: The figure above shows the initial grid.
// Notice that the fire is contained by walls and you will always be able to
// safely reach the safehouse.
// Thus, 10⁹ is returned.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 300 
// 4 <= m * n <= 2 * 10⁴ 
// grid[i][j] is either 0, 1, or 2. 
// grid[0][0] == grid[m - 1][n - 1] == 0 
// 
//
// 👍 149 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Id：&emsp;&emsp;2258
 * <p>
 * Name：Escape the Spreading Fire
 *
 * @author Yuri
 * @since 2024-06-05 10:36:05
 */

public class EscapeTheSpreadingFire {

    public static void main(String[] args) {
        Solution solution = new EscapeTheSpreadingFire().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 先对所有fire做bfs把所有格子被火烧到的时间做记录，这里先对grid中各值进行重新映射，然后直接用进行grid记录
         * <p>
         * 再从(0,0)开始进行bfs，对于每个可走格子，如果到达时火还没烧到则表示可以前进，此外进行计算要到达该格子最多能在起始点停留多久？
         * 对路径上的停留时间取最小值，Math.min(w, grid[a][b] - 1 - (v + 1))。
         * <p>
         * 注意1：题目说火和人同时到达(m-1,n-1)是允许的，所以在计算最后一格时其可以停留时间为Math.min(w, grid[a][b] - (v + 1))
         * <p>
         * 注意2：题目求得是到达目标点可以停留的最大时间，不是到达目标点的最短路径，要考虑有多条路径的情况（例57）！所以达到目标点不能直接
         * 返回，此外目标点也不能加入队列（因为是用grid进行标记，所以也不能标记）
         */
        public int maximumMinutes(int[][] grid) {
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int m = grid.length, n = grid[0].length;
            Deque<int[]> fire = new ArrayDeque<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) grid[i][j] = -2;
                    else if (grid[i][j] == 0) grid[i][j] = Integer.MAX_VALUE;
                    else {
                        grid[i][j] = 0;
                        fire.add(new int[]{i, j});
                    }
                }
            }
            while (!fire.isEmpty()) {
                int[] q = fire.poll();
                int x = q[0], y = q[1];
                for (int[] d : dir) {
                    int a = x + d[0], b = y + d[1];
                    if (a >= 0 && a < m && b >= 0 && b < n && grid[a][b] == Integer.MAX_VALUE) {
                        grid[a][b] = grid[x][y] + 1;
                        fire.add(new int[]{a, b});
                    }
                }
            }
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{0, 0, 0, (int) 1e9});
            int ans = -1;
            while (!deque.isEmpty()) {
                int[] q = deque.poll();
                int x = q[0], y = q[1], v = q[2], w = q[3];
                for (int[] d : dir) {
                    int a = x + d[0], b = y + d[1];
                    if (a >= 0 && a < m && b >= 0 && b < n && grid[a][b] >= v + 1) {
                        if (a == m - 1 && b == n - 1) ans = Math.max(ans, Math.min(w, grid[a][b] - (v + 1)));
                        else {
                            deque.add(new int[]{a, b, v + 1, Math.min(w, grid[a][b] - 1 - (v + 1))});
                            grid[a][b] = -2;
                        }
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}