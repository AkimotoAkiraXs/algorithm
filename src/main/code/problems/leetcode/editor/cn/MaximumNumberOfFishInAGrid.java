// You are given a 0-indexed 2D matrix grid of size m x n, where (r, c)
// represents:
//
// 
// A land cell if grid[r][c] = 0, or 
// A water cell containing grid[r][c] fish, if grid[r][c] > 0. 
// 
//
// A fisher can start at any water cell (r, c) and can do the following 
// operations any number of times:
//
// 
// Catch all the fish at cell (r, c), or 
// Move to any adjacent water cell. 
// 
//
// Return the maximum number of fish the fisher can catch if he chooses his 
// starting cell optimally, or 0 if no water cell exists.
//
// An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 
// 1), (r + 1, c) or (r - 1, c) if it exists.
//
// 
// Example 1: 
// 
// 
// Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
// Output: 7
// Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move
// to cell (2,3) and collect 4 fish.
// 
//
// Example 2: 
// 
// 
// Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
// Output: 1
// Explanation: The fisher can start at cells (0,0) or (3,3) and collect a
// single fish.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// 0 <= grid[i][j] <= 10 
// 
//
// 👍 15 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2658
 * <p>
 * Name：Maximum Number of Fish in a Grid
 *
 * @author Yuri
 * @since 2024-05-17 18:03:05
 */

public class MaximumNumberOfFishInAGrid {

    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfFishInAGrid().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] vis;
        int[][] grid;
        int x, y;

        public int findMaxFish(int[][] grid) {
            this.grid = grid;
            x = grid.length;
            y = grid[0].length;
            vis = new boolean[x][y];
            int res = 0;
            for (int i = 0; i < x; i++)
                for (int j = 0; j < y; j++)
                    res = Math.max(res, dfs(i, j));
            return res;
        }

        private int dfs(int i, int j) {
            if (i < 0 || i >= x || j < 0 || j >= y || grid[i][j] == 0 || vis[i][j]) return 0;
            int res = grid[i][j];
            vis[i][j] = true;
            for (int[] d : dir) res += dfs(i + d[0], j + d[1]);
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}