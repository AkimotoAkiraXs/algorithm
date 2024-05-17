// You are given row x col grid representing a map where grid[i][j] = 1
// represents land and grid[i][j] = 0 represents water.
//
// Grid cells are connected horizontally/vertically (not diagonally). The grid 
// is completely surrounded by water, and there is exactly one island (i.e., one or
// more connected land cells).
//
// The island doesn't have "lakes", meaning the water inside isn't connected to 
// the water around the island. One cell is a square with side length 1. The grid
// is rectangular, width and height don't exceed 100. Determine the perimeter of
// the island.
//
// 
// Example 1: 
// 
// 
// Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
// Output: 16
// Explanation: The perimeter is the 16 yellow stripes in the image above.
// 
//
// Example 2: 
//
// 
// Input: grid = [[1]]
// Output: 4
// 
//
// Example 3: 
//
// 
// Input: grid = [[1,0]]
// Output: 4
// 
//
// 
// Constraints: 
//
// 
// row == grid.length 
// col == grid[i].length 
// 1 <= row, col <= 100 
// grid[i][j] is 0 or 1. 
// There is exactly one island in grid. 
// 
//
// 👍 753 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;463
 * <p>
 * Name：Island Perimeter
 *
 * @author Yuri
 * @since 2024-05-17 16:33:12
 */

public class IslandPerimeter {

    public static void main(String[] args) {
        Solution solution = new IslandPerimeter().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[][] vis;
        int x, y;
        int[][] grid;
        int[][] dire = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int islandPerimeter(int[][] grid) {
            this.grid = grid;
            x = grid.length;
            y = grid[0].length;
            vis = new boolean[x][y];
            for (int i = 0; i < x; i++)
                for (int j = 0; j < y; j++) if (grid[i][j] != 0) return dfs(i, j);
            return 0;
        }

        public int dfs(int i, int j) {
            if (i < 0 || i >= x || j < 0 || j >= y || grid[i][j] == 0) return 1;
            if (vis[i][j]) return 0;
            vis[i][j] = true;
            int res = 0;
            for (int[] d : dire) res += dfs(i + d[0], j + d[1]);
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}