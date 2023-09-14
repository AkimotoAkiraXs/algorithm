// On a 0-indexed 8 x 8 chessboard, there can be multiple black queens ad one
// white king.
//
// You are given a 2D integer array queens where queens[i] = [xQueeni, yQueeni] 
// represents the position of the iᵗʰ black queen on the chessboard. You are also
// given an integer array king of length 2 where king = [xKing, yKing] represents
// the position of the white king.
//
// Return the coordinates of the black queens that can directly attack the king.
// You may return the answer in any order. 
//
// 
// Example 1: 
// 
// 
// Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
// Output: [[0,1],[1,0],[3,3]]
// Explanation: The diagram above shows the three queens that can directly
// attack the king and the three queens that cannot attack the king (i.e., marked with
// red dashes).
// 
//
// Example 2: 
// 
// 
// Input: queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
// Output: [[2,2],[3,4],[4,4]]
// Explanation: The diagram above shows the three queens that can directly
// attack the king and the three queens that cannot attack the king (i.e., marked with
// red dashes).
// 
//
// 
// Constraints: 
//
// 
// 1 <= queens.length < 64 
// queens[i].length == king.length == 2 
// 0 <= xQueeni, yQueeni, xKing, yKing < 8 
// All the given positions are unique. 
// 
//
// 👍 80 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Id：&emsp;&emsp;1222
 * <p>
 * Name：Queens That Can Attack the King
 *
 * @author Yuri
 * @since 2023-09-14 10:22:53
 */

public class QueensThatCanAttackTheKing {
    public static void main(String[] args) {
        Solution solution = new QueensThatCanAttackTheKing().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            var dirs = new int[][]{{1, 1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            List<List<Integer>> ans = new ArrayList<>();
            var hash = new HashSet<>();
            for (var queen : queens) hash.add(queen[0] + queen[1] * 8);
            for (var dir : dirs) {
                int x = king[0], y = king[1];
                while (x + dir[0] >= 0 && x + dir[0] < 8 && y + dir[1] >= 0 && y + dir[1] < 8) {
                    x += dir[0];
                    y += dir[1];
                    if (hash.contains(x + y * 8)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(x);
                        list.add(y);
                        ans.add(list);
                        break;
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}