// You are given a 0-indexed 2D matrix grid of size n x n, where (r, c)
// represents:
//
// 
// A cell containing a thief if grid[r][c] = 1 
// An empty cell if grid[r][c] = 0 
// 
//
// You are initially positioned at cell (0, 0). In one move, you can move to 
// any adjacent cell in the grid, including cells containing thieves.
//
// The safeness factor of a path on the grid is defined as the minimum 
// manhattan distance from any cell in the path to any thief in the grid.
//
// Return the maximum safeness factor of all paths leading to cell (n - 1, n - 1
//). 
//
// An adjacent cell of cell (r, c), is one of the cells (r, c + 1), (r, c - 1), 
//(r + 1, c) and (r - 1, c) if it exists. 
//
// The Manhattan distance between two cells (a, b) and (x, y) is equal to |a - 
// x| + |b - y|, where |val| denotes the absolute value of val.
//
// 
// Example 1: 
// 
// 
// Input: grid = [[1,0,0],[0,0,0],[0,0,1]]
// Output: 0
// Explanation: All paths from (0, 0) to (n - 1, n - 1) go through the thieves
// in cells (0, 0) and (n - 1, n - 1).
// 
//
// Example 2: 
// 
// 
// Input: grid = [[0,0,1],[0,0,0],[0,0,0]]
// Output: 2
// Explanation: The path depicted in the picture above has a safeness factor of 2
// since:
//- The closest cell of the path to the thief at cell (0, 2) is cell (0, 0). 
// The distance between them is | 0 - 0 | + | 0 - 2 | = 2.
// It can be shown that there are no other paths with a higher safeness factor.
// 
//
// Example 3: 
// 
// 
// Input: grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]
// Output: 2
// Explanation: The path depicted in the picture above has a safeness factor of 2
// since:
//- The closest cell of the path to the thief at cell (0, 3) is cell (1, 2). 
// The distance between them is | 0 - 1 | + | 3 - 2 | = 2.
//- The closest cell of the path to the thief at cell (3, 0) is cell (3, 2). 
// The distance between them is | 3 - 3 | + | 0 - 2 | = 2.
// It can be shown that there are no other paths with a higher safeness factor.
// 
//
// 
// Constraints: 
//
// 
// 1 <= grid.length == n <= 400 
// grid[i].length == n 
// grid[i][j] is either 0 or 1. 
// There is at least one thief in the grid. 
// 
//
// 👍 59 👎 0

package problems.leetcode.editor.cn;

import com.google.common.collect.Lists;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Id：&emsp;&emsp;2812
 * <p>
 * Name：Find the Safest Path in a Grid
 *
 * @author Yuri
 * @since 2024-09-13 18:04:42
 */

public class FindTheSafestPathInAGrid {

    public static void main(String[] args) {
        Solution solution = new FindTheSafestPathInAGrid().new Solution();
        solution.maximumSafenessFactor(
            Stream.of(Lists.newArrayList(0, 0, 0, 1), Lists.newArrayList(0, 0, 0, 0), Lists.newArrayList(0, 0, 0, 0),
                Lists.newArrayList(1, 0, 0, 0)).collect(Collectors.toList()));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 1.先bfs预处理算出每个位置的安全系数。
         * 2.然后bfs进行搜索，vis（记录目前到达该位置的最大安全系数）进行标记，
         * 如果发现有比当前点更大的最大安全系数，就更新vis然后把并将该点重新放入队列。
         * <p>
         * 其实第二步最好的还是用二分，纯bfs险过
         */
        public int maximumSafenessFactor(List<List<Integer>> grid) {
            var dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int m = grid.size(), n = grid.get(0).size();
            var vis = new int[m][n];
            Deque<int[]> deque = new ArrayDeque<>();
            int[][] dis = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid.get(i).get(j) == 1) {
                        deque.add(new int[]{i, j, 0});
                        vis[i][j] = 1;
                    }
                }
            }

            while (!deque.isEmpty()) {
                int[] q = deque.poll();
                int i = q[0], j = q[1], rc = q[2];
                dis[i][j] = rc;
                for (var d : dir) {
                    int x = d[0] + i, y = d[1] + j;
                    if (x >= 0 && x < m && y >= 0 && y < n && vis[x][y] != 1) {
                        deque.add(new int[]{x, y, rc + 1});
                        vis[x][y] = 1;
                    }
                }
            }

            deque.add(new int[]{0, 0, dis[0][0]});
            vis = new int[m][n]; // 第二次bfs中，vis作为标记点是否可以重走
            vis[0][0] = dis[0][0];

            while (!deque.isEmpty()) {
                int[] q = deque.poll();
                int i = q[0], j = q[1];
                for (var d : dir) {
                    int x = d[0] + i, y = d[1] + j;
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        int min = Math.min(q[2], dis[x][y]);
                        if (vis[x][y] < min) {
                            deque.add(new int[]{x, y, min});
                            vis[x][y] = min;
                        }
                    }
                }
            }
            return vis[m - 1][n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}