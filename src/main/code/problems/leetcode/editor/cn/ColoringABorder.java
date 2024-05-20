// You are given an m x n integer matrix grid, and three integers row, col, and
// color. Each value in the grid represents the color of the grid square at that
// location.
//
// Two squares are called adjacent if they are next to each other in any of the 
// 4 directions.
//
// Two squares belong to the same connected component if they have the same 
// color and they are adjacent.
//
// The border of a connected component is all the squares in the connected 
// component that are either adjacent to (at least) a square not in the component, or
// on the boundary of the grid (the first or last row or column).
//
// You should color the border of the connected component that contains the 
// square grid[row][col] with color.
//
// Return the final grid. 
//
// 
// Example 1: 
// Input: grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
// Output: [[3,3],[3,2]]
// 
// Example 2: 
// Input: grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
// Output: [[1,3,3],[2,3,3]]
// 
// Example 3: 
// Input: grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
// Output: [[2,2,2],[2,1,2],[2,2,2]]
// 
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j], color <= 1000 
// 0 <= row < m 
// 0 <= col < n 
// 
//
// 👍 178 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1034
 * <p>
 * Name：Coloring A Border
 *
 * @author Yuri
 * @since 2024-05-20 18:44:48
 */

public class ColoringABorder {

    public static void main(String[] args) {
        Solution solution = new ColoringABorder().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] grid;
        int color;
        int x, y;
        boolean[][] vis;
        int origin;
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            this.grid = grid;
            this.color = color;
            x = grid.length;
            y = grid[0].length;
            vis = new boolean[x][y];
            origin = grid[row][col];
            dfs(row, col);
            return grid;
        }

        private boolean dfs(int i, int j) {
            if (i < 0 || i >= x || j < 0 || j >= y || (!vis[i][j] && grid[i][j] != origin)) return false;
            if (vis[i][j]) return true;
            vis[i][j] = true;
            boolean f = true;
            for (int[] d : dir) f &= dfs(i + d[0], j + d[1]);
            if (!f) grid[i][j] = color;
            return true;
        }


    }
// leetcode submit region end(Prohibit modification and deletion)

}