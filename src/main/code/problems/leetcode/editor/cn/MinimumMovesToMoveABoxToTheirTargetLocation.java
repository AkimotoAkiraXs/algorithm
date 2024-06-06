// A storekeeper is a game in which the player pushes boxes around in a
// warehouse trying to get them to target locations.
//
// The game is represented by an m x n grid of characters grid where each 
// element is a wall, floor, or box.
//
// Your task is to move the box 'B' to the target position 'T' under the 
// following rules:
//
// 
// The character 'S' represents the player. The player can move up, down, left, 
// right in grid if it is a floor (empty cell).
// The character '.' represents the floor which means a free cell to walk. 
// The character '#' represents the wall which means an obstacle (impossible to 
// walk there).
// There is only one box 'B' and one target cell 'T' in the grid. 
// The box can be moved to an adjacent free cell by standing next to the box 
// and then moving in the direction of the box. This is a push.
// The player cannot walk through the box. 
// 
//
// Return the minimum number of pushes to move the box to the target. If there 
// is no way to reach the target, return -1.
//
// 
// Example 1: 
// 
// 
// Input: grid = [["#","#","#","#","#","#"],
//               ["#","T","#","#","#","#"],
//               ["#",".",".","B",".","#"],
//               ["#",".","#","#",".","#"],
//               ["#",".",".",".","S","#"],
//               ["#","#","#","#","#","#"]]
// Output: 3
// Explanation: We return only the number of times the box is pushed.
//
// Example 2: 
//
// 
// Input: grid = [["#","#","#","#","#","#"],
//               ["#","T","#","#","#","#"],
//               ["#",".",".","B",".","#"],
//               ["#","#","#","#",".","#"],
//               ["#",".",".",".","S","#"],
//               ["#","#","#","#","#","#"]]
// Output: -1
// 
//
// Example 3: 
//
// 
// Input: grid = [["#","#","#","#","#","#"],
//               ["#","T",".",".","#","#"],
//               ["#",".","#","B",".","#"],
//               ["#",".",".",".",".","#"],
//               ["#",".",".",".","S","#"],
//               ["#","#","#","#","#","#"]]
// Output: 5
// Explanation: push the box down, left, left, up and up.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 20 
// grid contains only characters '.', '#', 'S', 'T', or 'B'. 
// There is only one character 'S', 'B', and 'T' in the grid. 
// 
//
// 👍 206 👎 0

package problems.leetcode.editor.cn;

import com.sun.tools.javac.Main;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Id：&emsp;&emsp;1263
 * <p>
 * Name：Minimum Moves to Move a Box to Their Target Location
 *
 * @author Yuri
 * @since 2024-06-05 18:16:22
 */

public class MinimumMovesToMoveABoxToTheirTargetLocation {

    public static void main(String[] args) {
        Solution solution = new MinimumMovesToMoveABoxToTheirTargetLocation().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 判断箱子位置需要前进方向和后退方向是否为空，此外后退方向人还必须能到达，因为箱子位置时刻变动，所以每次都要重新判断。
     * <p>
     * 注意1：面对箱子挡路情况，可以先把箱子往前推一格，人过去后再把箱子从另一边推回来，所vis标记数组不但要记录箱子位置还要记录人的位置（方向）
     */
    class Solution {

        char[][] grid;
        int m, n;
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int minPushBox(char[][] grid) {
            this.grid = grid;
            m = grid.length;
            n = grid[0].length;
            int px = -1, py = -1, bx = -1, by = -1, tx = -1, ty = -1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char c = grid[i][j];
                    if (c == 'S') {
                        px = i;
                        py = j;
                        grid[i][j] = '.';
                    } else if (c == 'B') {
                        bx = i;
                        by = j;
                        grid[i][j] = '.';
                    } else if (c == 'T') {
                        tx = i;
                        ty = j;
                        grid[i][j] = '.';
                    }
                }
            }
            Deque<int[]> deque = new ArrayDeque<>();
            boolean[][][][] vis = new boolean[m][n][m][n];
            deque.add(new int[]{bx, by, px, py, 0});
            vis[bx][by][px][py] = true;
            while (!deque.isEmpty()) {
                int[] q = deque.poll();
                bx = q[0];
                by = q[1];
                px = q[2];
                py = q[3];
                int v = q[4];
                for (int[] di : dir) {
                    int a = bx + di[0], b = by + di[1], c = bx - di[0], d = by - di[1];
                    if (a >= 0 && a < m && b >= 0 && b < n && grid[a][b] == '.' && !vis[a][b][px][py] && arrive(px, py,
                        c, d, bx,
                        by, new boolean[m][n])) {
                        if (a == tx && b == ty) return v + 1;
                        deque.add(new int[]{a, b, bx, by, v + 1});
                        vis[a][b][px][py] = true;
                    }
                }
            }
            return -1;
        }

        private boolean arrive(int px, int py, int tx, int ty, int bx, int by, boolean[][] vis) {
            if (px < 0 || px >= m || py < 0 || py >= n || vis[px][py] || grid[px][py] != '.' || (px == bx && py == by))
                return false;
            if (px == tx && py == ty) return true;
            vis[px][py] = true;
            for (int[] d : dir)
                if (arrive(px + d[0], py + d[1], tx, ty, bx, by, vis)) return true;
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}