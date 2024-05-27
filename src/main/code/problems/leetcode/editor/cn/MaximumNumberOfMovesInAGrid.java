// You are given a 0-indexed m x n matrix grid consisting of positive integers.
//
// You can start at any cell in the first column of the matrix, and traverse 
// the grid in the following way:
//
// 
// From a cell (row, col), you can move to any of the cells: (row - 1, col + 1),
// (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move 
// to, should be strictly bigger than the value of the current cell.
// 
//
// Return the maximum number of moves that you can perform. 
//
// 
// Example 1: 
// 
// 
// Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
// Output: 3
// Explanation: We can start at the cell (0, 0) and make the following moves:
//- (0, 0) -> (0, 1).
//- (0, 1) -> (1, 2).
//- (1, 2) -> (2, 3).
// It can be shown that it is the maximum number of moves that can be made.
//
// Example 2: 
//
// 
//
// Input: grid = [[3,2,4],[2,1,9],[1,1,7]]
// Output: 0
// Explanation: Starting from any cell in the first column we cannot perform any
// moves.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 1000 
// 4 <= m * n <= 10⁵ 
// 1 <= grid[i][j] <= 10⁶ 
// 
//
// 👍 56 👎 0

package problems.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Id：&emsp;&emsp;2684
 * <p>
 * Name：Maximum Number of Moves in a Grid
 *
 * @author Yuri
 * @since 2024-05-27 17:33:46
 */

public class MaximumNumberOfMovesInAGrid {

    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfMovesInAGrid().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxMoves(int[][] grid) {
            int x = grid.length, y = grid[0].length;
            Deque<int[]> q = new LinkedList<>();
            for (int i = 0; i < x; i++) q.add(new int[]{i * y, 0});
            int val = 0;
            boolean[][] vis = new boolean[x][y];
            while (!q.isEmpty()) {
                int[] p = q.poll();
                int position = p[0];
                val = p[1];
                int i = position / y, j = position % y;
                for (int k = -1; k <= 1; k++) {
                    int a = i + k, b = j + 1;
                    if (a >= 0 && a < x && b >= 0 && b < y && grid[a][b] > grid[i][j] && !vis[a][b]) {
                        q.add(new int[]{a * y + b, val + 1});
                        vis[a][b] = true;
                    }
                }
            }
            return val;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}