//Given an n x n grid containing only values 0 and 1, where 0 represents water 
//and 1 represents land, find a water cell such that its distance to the nearest 
//land cell is maximized, and return the distance. If no land or water exists in 
//the grid, return -1. 
//
// The distance used in this problem is the Manhattan distance: the distance 
//between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
//Output: 2
//Explanation: The cell (1, 1) is as far as possible from all the land with 
//distance 2.
// 
//
// Example 2: 
// 
// 
//Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
//Output: 4
//Explanation: The cell (2, 2) is as far as possible from all the land with 
//distance 4.
// 
//
// 
// Constraints: 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] is 0 or 1 
// 
//
// 👍 374 👎 0

package problems.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Id：&emsp;&emsp;1162
 * <p>
 * Name：As Far from Land as Possible
 *
 * @author Yuri
 * @since 2024-05-27 18:12:39
 */

public class AsFarFromLandAsPossible{
    public static void main(String[] args) {
        Solution solution = new AsFarFromLandAsPossible().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxDistance(int[][] grid) {
            int x = grid.length, y = grid[0].length;
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            Deque<int[]> queue = new LinkedList<>();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (grid[i][j] == 1) queue.add(new int[]{i * y + j, 0});
                }
            }
            if (queue.size() == x * y) return -1;
            int val = -1;
            while (!queue.isEmpty()) {
                int[] q = queue.poll();
                int p = q[0];
                int i = p / y, j = p % y;
                val = q[1];
                for (int[] d : dir) {
                    int a = i + d[0], b = j + d[1];
                    if (a >= 0 && a < x && b >= 0 && b < y && grid[a][b] == 0) {
                        queue.add(new int[]{a * y + b, val + 1});
                        grid[a][b] = 1;
                    }
                }
            }
            return val;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}