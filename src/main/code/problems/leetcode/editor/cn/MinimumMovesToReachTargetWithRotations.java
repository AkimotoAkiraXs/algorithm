// In an n*n grid, there is a snake that spans 2 cells and starts moving from
// the top left corner at (0, 0) and (0, 1). The grid has empty cells represented by
// zeros and blocked cells represented by ones. The snake wants to reach the lower
// right corner at (n-1, n-2) and (n-1, n-1).
//
// In one move the snake can: 
//
// 
// Move one cell to the right if there are no blocked cells there. This move 
// keeps the horizontal/vertical position of the snake as it is.
// Move down one cell if there are no blocked cells there. This move keeps the 
// horizontal/vertical position of the snake as it is.
// Rotate clockwise if it's in a horizontal position and the two cells under it 
// are both empty. In that case the snake moves from (r, c) and (r, c+1) to (r, c)
// and (r+1, c).
// Rotate counterclockwise if it's in a vertical position and the two cells to 
// its right are both empty. In that case the snake moves from (r, c) and (r+1, c)
// to (r, c) and (r, c+1).
// 
//
// Return the minimum number of moves to reach the target. 
//
// If there is no way to reach the target, return -1. 
//
// 
// Example 1: 
//
// 
//
// 
// Input: grid = [[0,0,0,0,0,1],
//               [1,1,0,0,1,0],
//               [0,0,0,0,1,1],
//               [0,0,1,0,1,0],
//               [0,1,1,0,0,0],
//               [0,1,1,0,0,0]]
// Output: 11
// Explanation:
// One possible solution is [right, right, rotate clockwise, right, down, down,
// down, down, rotate counterclockwise, right, down].
// 
//
// Example 2: 
//
// 
// Input: grid = [[0,0,1,1,1,1],
//               [0,0,0,0,1,1],
//               [1,1,0,0,0,1],
//               [1,1,1,0,0,1],
//               [1,1,1,0,0,1],
//               [1,1,1,0,0,0]]
// Output: 9
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 100 
// 0 <= grid[i][j] <= 1 
// It is guaranteed that the snake starts at empty cells. 
// 
//
// 👍 147 👎 0

package problems.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Id：&emsp;&emsp;1210
 * <p>
 * Name：Minimum Moves to Reach Target with Rotations
 *
 * @author Yuri
 * @since 2024-05-30 09:45:38
 */

public class MinimumMovesToReachTargetWithRotations {

    public static void main(String[] args) {
        Solution solution = new MinimumMovesToReachTargetWithRotations().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 利用异或控制方位
        public int minimumMoves(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dir = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}; // 三元分别表示x,y和是否转向
            boolean[][][] vis = new boolean[2][m][n];
            Deque<int[]> deque = new LinkedList<>();
            deque.add(new int[]{0, 0, 0});
            vis[0][0][0] = true;
            while (!deque.isEmpty()) {
                int[] q = deque.poll();
                int pos = q[0], val = q[1], k = q[2]; // k=0表示横着，1表示竖着
                int x = pos / n, y = pos % n;
                for (int[] d : dir) {
                    int a = x + d[0], b = y + d[1], s = k ^ d[2]; // s=0表示横着，1表示竖着，(a,b)表示尾坐标
                    int a1 = a + s, b1 = b + (s ^ 1); // 表示头坐标
                    if (a1 < m && b1 < n && !vis[s][a][b] && grid[a][b] == 0 && grid[a1][b1] == 0 &&
                        (d[2] == 0 || grid[x + 1][y + 1] == 0)) {
                        if (a == m - 1 && b == n - 2) return val + 1;
                        vis[s][a][b] = true;
                        deque.add(new int[]{a * n + b, val + 1, s});
                    }
                }
            }
            return -1;
        }

        public int minimumMoves_(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            boolean[][][] vis = new boolean[m][n][2];
            vis[0][1][0] = true;
            Deque<int[]> deque = new LinkedList<>();
            deque.add(new int[]{1, 0, 0});

            while (!deque.isEmpty()) {
                int[] q = deque.poll();
                int pos = q[0], val = q[1], k = q[2];
                int x = pos / n, y = pos % n;
                if (k == 0) {
                    int r = 1;

                    // 转动
                    int a = x + 1, b = y - 1;
                    if (a < m && b >= 0 && grid[a][b] == 0 && grid[x + 1][y] == 0 && !vis[a][b][r]) {
                        vis[a][b][r] = true;
                        deque.add(new int[]{a * n + b, val + 1, r});
                    }

                    // 右进
                    b = y + 1;
                    if (b < n && grid[x][b] == 0 && !vis[x][b][k]) {
                        if (x == m - 1 && b == n - 1) return val + 1;
                        vis[x][b][k] = true;
                        deque.add(new int[]{x * n + b, val + 1, k});
                    }

                    // 平行下移
                    a = x + 1;
                    if (a < m && grid[a][y] == 0 && grid[a][y - 1] == 0 && !vis[a][y][k]) {
                        if (a == m - 1 && y == n - 1) return val + 1;
                        vis[a][y][k] = true;
                        deque.add(new int[]{a * n + y, val + 1, k});
                    }
                } else {
                    int r = 0;

                    int a = x - 1, b = y + 1;
                    if (a >= 0 && b < n && grid[a][b] == 0 && grid[x][y + 1] == 0 && !vis[a][b][r]) {
                        vis[a][b][r] = true;
                        deque.add(new int[]{a * n + b, val + 1, r});
                    }

                    b = y + 1;
                    if (b < n && grid[x][b] == 0 && grid[x - 1][b] == 0 && !vis[x][b][k]) {
                        vis[x][b][k] = true;
                        deque.add(new int[]{x * n + b, val + 1, k});
                    }

                    a = x + 1;
                    if (a < m && grid[a][y] == 0 && !vis[a][y][k]) {
                        vis[a][y][k] = true;
                        deque.add(new int[]{a * n + y, val + 1, k});
                    }
                }
            }
            return -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}