// 骑士在一张 n x n 的棋盘上巡视。在有效的巡视方案中，骑士会从棋盘的 左上角 出发，并且访问棋盘上的每个格子 恰好一次 。
//
// 给你一个 n x n 的整数矩阵 grid ，由范围 [0, n * n - 1] 内的不同整数组成，其中 grid[row][col] 表示单元格 (
// row, col) 是骑士访问的第 grid[row][col] 个单元格。骑士的行动是从下标 0 开始的。
//
// 如果 grid 表示了骑士的有效巡视方案，返回 true；否则返回 false。 
//
// 注意，骑士行动时可以垂直移动两个格子且水平移动一个格子，或水平移动两个格子且垂直移动一个格子。下图展示了骑士从某个格子出发可能的八种行动路线。 
//
// 
//
// 示例 1： 
// 输入：grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13
//,2,7,22]]
// 输出：true
// 解释：grid 如上图所示，可以证明这是一个有效的巡视方案。
// 
//
// 示例 2： 
// 输入：grid = [[0,3,6],[5,8,1],[2,7,4]]
// 输出：false
// 解释：grid 如上图所示，考虑到骑士第 7 次行动后的位置，第 8 次行动是无效的。
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 3 <= n <= 7 
// 0 <= grid[row][col] < n * n 
// grid 中的所有整数 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 模拟 👍 30 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2596
 * <p>
 * Name：检查骑士巡视方案
 *
 * @author Yuri
 * @since 2023-09-13 11:38:40
 */

public class CheckKnightTourConfiguration {
    public static void main(String[] args) {
        Solution solution = new CheckKnightTourConfiguration().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] step = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {1, -2}, {-2, 1}, {-1, -2}, {-2, -1}};
        int[][] grid;
        int X, Y;

        public boolean checkValidGrid(int[][] grid) {
            this.grid = grid;
            X = grid.length;
            Y = grid[0].length;
            return dfs(0, 0, 0);
        }

        // 可以优化，但没必要
        boolean dfs(int x, int y, int next) {
            if (x < 0 || x >= X || y < 0 || y >= Y) return false;
            if (grid[x][y] != next) return false;
            if (next == X * Y - 1) return true;
            boolean res = false;
            for (int i = 0; i < 8; i++) res |= dfs(x + step[i][0], y + step[i][1], next + 1);
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}