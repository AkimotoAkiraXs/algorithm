// You are given an m x n grid. Each cell of grid represents a street. The
// street of grid[i][j] can be:
//
// 
// 1 which means a street connecting the left cell and the right cell. 
// 2 which means a street connecting the upper cell and the lower cell. 
// 3 which means a street connecting the left cell and the lower cell. 
// 4 which means a street connecting the right cell and the lower cell. 
// 5 which means a street connecting the left cell and the upper cell. 
// 6 which means a street connecting the right cell and the upper cell. 
// 
// 
// You will initially start at the street of the upper-left cell (0, 0). A 
// valid path in the grid is a path that starts from the upper left cell (0, 0) and
// ends at the bottom-right cell (m - 1, n - 1). The path should only follow the
// streets.
//
// Notice that you are not allowed to change any street. 
//
// Return true if there is a valid path in the grid or false otherwise. 
//
// 
// Example 1: 
// 
// 
// Input: grid = [[2,4,3],[6,5,2]]
// Output: true
// Explanation: As shown you can start at cell (0, 0) and visit all the cells of
// the grid to reach (m - 1, n - 1).
// 
//
// Example 2: 
// 
// 
// Input: grid = [[1,2,1],[1,2,1]]
// Output: false
// Explanation: As shown you the street at cell (0, 0) is not connected with any
// street of any other cell and you will get stuck at cell (0, 0)
// 
//
// Example 3: 
//
// 
// Input: grid = [[1,1,2]]
// Output: false
// Explanation: You will get stuck at cell (0, 1) and you cannot reach cell (0, 2
//).
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// 1 <= grid[i][j] <= 6 
// 
//
// 👍 75 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1391
 * <p>
 * Name：Check if There is a Valid Path in a Grid
 *
 * @author Yuri
 * @since 2024-05-22 17:37:20
 */

public class CheckIfThereIsAValidPathInAGrid {

    public static void main(String[] args) {
        Solution solution = new CheckIfThereIsAValidPathInAGrid().new Solution();
        solution.hasValidPath(new int[][]{{1, 1, 2}});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] grid;
        int x, y;
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // vis标记某个方向某个图形是否有出口，vis[(d+2)%4]是判断是否有入口
        Boolean[][] vis = new Boolean[][]{
            {null, false, true, true, true, false, false},
            {null, true, false, false, true, false, true},
            {null, false, true, false, false, true, true},
            {null, true, false, true, false, true, false}
        };

        public boolean hasValidPath(int[][] grid) {
            this.grid = grid;
            x = grid.length;
            y = grid[0].length;
            return dfs(0, 0, 0);
        }

        private boolean dfs(int i, int j, int d) {
            if (i < 0 || i >= x || j < 0 || j >= y || grid[i][j] == 0 || (d != 0 && !vis[(d + 2) % 4][grid[i][j]]))
                return false;
            if (i == x - 1 && j == y - 1) return true;
            int k = grid[i][j];
            grid[i][j] = 0;
            boolean flag = false;
            for (int l = 0; l < 4; l++)
                if (vis[l][k])
                    flag |= dfs(i + dir[l][0], j + dir[l][1], l);
            return flag;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}