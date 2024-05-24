// Given a 2D array of characters grid of size m x n, you need to find if there
// exists any cycle consisting of the same value in grid.
//
// A cycle is a path of length 4 or more in the grid that starts and ends at 
// the same cell. From a given cell, you can move to one of the cells adjacent to it -
// in one of the four directions (up, down, left, or right), if it has the same 
// value of the current cell.
//
// Also, you cannot move to the cell that you visited in your last move. For 
// example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we
// visited (1, 1) which was the last visited cell.
//
// Return true if any cycle of the same value exists in grid, otherwise, return 
// false.
//
// 
// Example 1: 
//
// 
//
// 
// Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a",
//"a","a"]]
// Output: true
// Explanation: There are two valid cycles shown in different colors in the
// image below:
//
// 
//
// Example 2: 
//
// 
//
// 
// Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c",
//"c","c"]]
// Output: true
// Explanation: There is only one valid cycle highlighted in the image below:
//
// 
//
// Example 3: 
//
// 
//
// 
// Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
// Output: false
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid consists only of lowercase English letters. 
// 
//
// 👍 71 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1559
 * <p>
 * Name：Detect Cycles in 2D Grid
 *
 * @author Yuri
 * @since 2024-05-23 17:41:03
 */

public class DetectCyclesIn2dGrid {

    public static void main(String[] args) {
        Solution solution = new DetectCyclesIn2dGrid().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    // 环起点可以从任意点开始
    class Solution {
        char[][] grid;
        int x, y;
        int[][] path;
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public boolean containsCycle(char[][] grid) {
            this.grid = grid;
            x = grid.length;
            y = grid[0].length;
            path = new int[x][y];
            for (int i = 0; i < x; i++)
                for (int j = 0; j < y; j++)
                    if (dfs(i, j, grid[i][j], 0)) return true;
            return false;
        }

        private boolean dfs(int i, int j, int v, int p) {
            if (i < 0 || i >= x || j < 0 || j >= y || grid[i][j] != v) return false;
            if (path[i][j] != 0) return p - path[i][j] + 1 >= 4;
            path[i][j] = p + 1;
            boolean f = false;
            for (int[] d : dir) f = f || dfs(i + d[0], j + d[1], v, p + 1);
            return f;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}