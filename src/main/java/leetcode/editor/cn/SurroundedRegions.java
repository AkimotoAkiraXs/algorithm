//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X"
//,"X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 603 👎 0


/*
 * Id：130
 * Name：被围绕的区域
 * Date：2021-09-02 14:52:13
 */
package leetcode.editor.cn;

public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
        solution.solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean flag[][];
        char[][] b;
        int n, m;

        void dfs(int i, int j) {
            if (i >= n || i < 0 || j >= m || j < 0 || b[i][j] == 'X' || flag[i][j]) return;
            flag[i][j] = true;
            dfs(i + 1, j);
            dfs(i - 1, j);
            dfs(i, j + 1);
            dfs(i, j - 1);
        }

        public void solve(char[][] board) {
            if (board == null) return;
            b = board;
            n = board.length;
            m = board[0].length;
            flag = new boolean[n][m];

            for (int i = 0; i < board[0].length; i++) {
               dfs(0, i);
               dfs(n-1, i);
               dfs(i, 0);
               dfs(i, m-1);
            }

            for (int i = 1; i < board.length - 1; i++) {
                for (int j = 1; j < board[i].length - 1; j++) {
                    if (board[i][j] == 'O' && !flag[i][j]) board[i][j] = 'X';
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 