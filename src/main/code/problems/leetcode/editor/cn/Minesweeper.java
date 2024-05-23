// Let's play the minesweeper game (Wikipedia, online game)!
//
// You are given an m x n char matrix board representing the game board where: 
//
// 
// 'M' represents an unrevealed mine, 
// 'E' represents an unrevealed empty square, 
// 'B' represents a revealed blank square that has no adjacent mines (i.e., 
// above, below, left, right, and all 4 diagonals),
// digit ('1' to '8') represents how many mines are adjacent to this revealed 
// square, and
// 'X' represents a revealed mine. 
// 
//
// You are also given an integer array click where click = [clickr, clickc] 
// represents the next click position among all the unrevealed squares ('M' or 'E').
//
// Return the board after revealing this position according to the following 
// rules:
//
// 
// If a mine 'M' is revealed, then the game is over. You should change it to 
//'X'. 
// If an empty square 'E' with no adjacent mines is revealed, then change it to 
// a revealed blank 'B' and all of its adjacent unrevealed squares should be
// revealed recursively.
// If an empty square 'E' with at least one adjacent mine is revealed, then 
// change it to a digit ('1' to '8') representing the number of adjacent mines.
// Return the board when no more squares will be revealed. 
// 
//
// 
// Example 1: 
// 
// 
// Input: board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E",
//"E"],["E","E","E","E","E"]], click = [3,0]
// Output: [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],[
//"B","B","B","B","B"]]
// 
//
// Example 2: 
// 
// 
// Input: board = [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1",
//"B"],["B","B","B","B","B"]], click = [1,2]
// Output: [["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],[
//"B","B","B","B","B"]]
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 50 
// board[i][j] is either 'M', 'E', 'B', or a digit from '1' to '8'. 
// click.length == 2 
// 0 <= clickr < m 
// 0 <= clickc < n 
// board[clickr][clickc] is either 'M' or 'E'. 
// 
//
// 👍 378 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;529
 * <p>
 * Name：Minesweeper
 *
 * @author Yuri
 * @since 2024-05-23 16:08:08
 */

public class Minesweeper {

    public static void main(String[] args) {
        Solution solution = new Minesweeper().new Solution();
        solution.updateBoard(
            new char[][]{{'B', '1', 'E', '1', 'B'}, {'B', '1', 'M', '1', 'B'}, {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}}, new int[]{1, 2});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        char[][] board;
        int x, y;
        boolean[][] vis;

        public char[][] updateBoard(char[][] board, int[] click) {
            int i = click[0], j = click[1];
            if (board[i][j] == 'M') {
                board[i][j] = 'X';
                return board;
            }
            this.board = board;
            x = board.length;
            y = board[0].length;
            vis = new boolean[x][y];
            dfs(i, j);
            return this.board;
        }

        public void dfs(int i, int j) {
            if (i < 0 || j < 0 || i >= x || j >= y) return;
            char c = board[i][j];
            if (c == 'M') return;

            if (!vis[i][j] && c == 'E') {
                vis[i][j] = true;
                int cnt = 0;
                for (int k = -1; k <= 1; k++)
                    for (int l = -1; l <= 1; l++)
                        cnt += count(i + k, j + l);
                if (cnt == 0) {
                    board[i][j] = 'B';
                    for (int k = -1; k <= 1; k++)
                        for (int l = -1; l <= 1; l++)
                            dfs(i + k, j + l);
                } else board[i][j] = (char) (cnt + '0');
            }
        }

        // 专门用于计数
        public int count(int i, int j) {
            if (i < 0 || j < 0 || i >= x || j >= y) return 0;
            if (board[i][j] == 'M') return 1;
            return 0;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}