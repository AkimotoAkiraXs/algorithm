//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1316 👎 0


/*
 * Id：200
 * Name：岛屿数量
 * Date：2021-09-08 10:11:37
 */
package leetcode.editor.cn;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[][] map;
        int m, n;
        int ans = 0;

        void dfs(int x, int y, boolean flag) {
            if (x >= m || x < 0 || y >= n || y < 0 || map[x][y] != '1') return;
            map[x][y] = '0';
            if (flag) {
                ans++;
            }
            dfs(x + 1, y, false);
            dfs(x - 1, y, false);
            dfs(x, y + 1, false);
            dfs(x, y - 1, false);
        }

        public int numIslands(char[][] grid) {
            if (grid == null) {
                return 0;
            }
            map = grid;
            m = grid.length;
            n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(i, j, true);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 