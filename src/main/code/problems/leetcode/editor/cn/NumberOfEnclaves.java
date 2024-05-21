// You are given an m x n binary matrix grid, where 0 represents a sea cell and 1
// represents a land cell. 
//
// A move consists of walking from one land cell to another adjacent (4-
// directionally) land cell or walking off the boundary of the grid.
//
// Return the number of land cells in grid for which we cannot walk off the 
// boundary of the grid in any number of moves.
//
// 
// Example 1: 
// 
// 
// Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
// Output: 3
// Explanation: There are three 1s that are enclosed by 0s, and one 1 that is
// not enclosed because its on the boundary.
// 
//
// Example 2: 
// 
// 
// Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
// Output: 0
// Explanation: All 1s are either on the boundary or can reach the boundary.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] is either 0 or 1. 
// 
//
// 👍 272 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1020
 * <p>
 * Name：Number of Enclaves
 *
 * @author Yuri
 * @since 2024-05-20 19:31:34
 */

public class NumberOfEnclaves {

    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] grid;
        int x, y;
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int cnt;

        public int numEnclaves(int[][] grid) {
            this.grid = grid;
            x = grid.length;
            y = grid[0].length;
            int res = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    cnt = 0;
                    if (dfs(i, j)) res += cnt;
                }
            }
            return res;
        }

        private boolean dfs(int i, int j) {
            if (i < 0 || i >= x || j < 0 || j >= y) return false;
            if (grid[i][j] == 0) return true;
            grid[i][j] = 0;
            cnt++;
            boolean f = true;
            for (int[] d : dir) f &= dfs(i + d[0], j + d[1]);
            return f;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}