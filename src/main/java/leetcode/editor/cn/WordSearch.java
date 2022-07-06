//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1354 👎 0


package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;79
 * <p>
 * Name：单词搜索
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */
public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] vis;
        boolean ans = false;
        char[][] b;
        String w;

        public boolean exist(char[][] board, String word) {
            w = word;
            b = board;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != word.charAt(0)) continue;
                    vis = new boolean[board.length][board[0].length];
                    dfs(i, j, 0);
                }
            }
            return ans;
        }

        void dfs(int x, int y, int k) {
            vis[x][y] = true;
            if (k == w.length() - 1) {
                ans = true;
                return;
            }
            if (!ans && x > 0 && b[x - 1][y] == w.charAt(k + 1) && !vis[x - 1][y]) dfs(x - 1, y, k + 1);
            if (!ans && y > 0 && b[x][y - 1] == w.charAt(k + 1) && !vis[x][y - 1]) dfs(x, y - 1, k + 1);
            if (!ans && x < b.length - 1 && b[x + 1][y] == w.charAt(k + 1) && !vis[x + 1][y]) dfs(x + 1, y, k + 1);
            if (!ans && y < b[0].length - 1 && b[x][y + 1] == w.charAt(k + 1) && !vis[x][y + 1]) dfs(x, y + 1, k + 1);
            vis[x][y] = false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}