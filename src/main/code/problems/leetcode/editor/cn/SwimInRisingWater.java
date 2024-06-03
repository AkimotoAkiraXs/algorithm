// You are given an n x n integer matrix grid where each value grid[i][j]
// represents the elevation at that point (i, j).
//
// The rain starts to fall. At time t, the depth of the water everywhere is t. 
// You can swim from a square to another 4-directionally adjacent square if and
// only if the elevation of both squares individually are at most t. You can swim
// infinite distances in zero time. Of course, you must stay within the boundaries of
// the grid during your swim.
//
// Return the least time until you can reach the bottom right square (n - 1, n -
// 1) if you start at the top left square (0, 0). 
//
// 
// Example 1: 
// 
// 
// Input: grid = [[0,2],[1,3]]
// Output: 3
// Explanation:
// At time 0, you are in grid location (0, 0).
// You cannot go anywhere else because 4-directionally adjacent neighbors have a
// higher elevation than t = 0.
// You cannot reach point (1, 1) until time 3.
// When the depth of water is 3, we can swim anywhere inside the grid.
// 
//
// Example 2: 
// 
// 
// Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[
// 10,9,8,7,6]]
// Output: 16
// Explanation: The final route is shown.
// We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
// 
//
// 
// Constraints: 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 50 
// 0 <= grid[i][j] < n² 
// Each value grid[i][j] is unique. 
// 
//
// 👍 301 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Id：&emsp;&emsp;778
 * <p>
 * Name：Swim in Rising Water
 *
 * @author Yuri
 * @since 2024-06-03 18:02:11
 */

public class SwimInRisingWater {

    public static void main(String[] args) {
        Solution solution = new SwimInRisingWater().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // bfs+优先队列，思路和Prim，Dijkstra差不多
        public int swimInWater(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int[][] cnt = new int[m][n];
            for (int[] c : cnt) Arrays.fill(c, -1);
            cnt[0][0] = grid[0][0];
            TreeSet<Integer> q = new TreeSet<>((a, b) -> {
                if (cnt[a / n][a % n] == cnt[b / n][b % n]) return a - b;
                return cnt[a / n][a % n] - cnt[b / n][b % n];
            });
            q.add(0);
            while (!q.isEmpty()) {
                Integer pos = q.pollFirst();
                int x = pos / n, y = pos % n;
                if (x == m - 1 && y == n - 1) return cnt[m - 1][n - 1];
                for (int[] d : dir) {
                    int a = x + d[0], b = y + d[1];
                    if (a >= 0 && a < m && b >= 0 && b < n && cnt[a][b] == -1) {
                        cnt[a][b] = Math.max(cnt[x][y], grid[a][b]);
                        q.add(a * n + b);
                    }
                }
            }
            return -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}