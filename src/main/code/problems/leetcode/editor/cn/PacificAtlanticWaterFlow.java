// There is an m x n rectangular island that borders both the Pacific Ocean and
// Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and
// the Atlantic Ocean touches the island's right and bottom edges.
//
// The island is partitioned into a grid of square cells. You are given an m x 
// n integer matrix heights where heights[r][c] represents the height above sea
// level of the cell at coordinate (r, c).
//
// The island receives a lot of rain, and the rain water can flow to 
// neighboring cells directly north, south, east, and west if the neighboring cell's height
// is less than or equal to the current cell's height. Water can flow from any cell
// adjacent to an ocean into the ocean.
//
// Return a 2D list of grid coordinates result where result[i] = [ri, ci] 
// denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic
// oceans.
//
// 
// Example 1: 
// 
// 
// Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//
// Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// Explanation: The following cells can flow to the Pacific and Atlantic oceans,
// as shown below:
//[0,4]: [0,4] -> Pacific Ocean 
//       [0,4] -> Atlantic Ocean
//[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
//       [1,3] -> [1,4] -> Atlantic Ocean
//[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
//       [1,4] -> Atlantic Ocean
//[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
//       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
//[3,0]: [3,0] -> Pacific Ocean 
//       [3,0] -> [4,0] -> Atlantic Ocean
//[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
//       [3,1] -> [4,1] -> Atlantic Ocean
//[4,0]: [4,0] -> Pacific Ocean 
//       [4,0] -> Atlantic Ocean
// Note that there are other possible paths for these cells to flow to the
// Pacific and Atlantic oceans.
// 
//
// Example 2: 
//
// 
// Input: heights = [[1]]
// Output: [[0,0]]
// Explanation: The water can flow from the only cell to the Pacific and
// Atlantic oceans.
// 
//
// 
// Constraints: 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
//
// 👍 689 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Id：&emsp;&emsp;417
 * <p>
 * Name：Pacific Atlantic Water Flow
 *
 * @author Yuri
 * @since 2024-05-23 14:27:58
 */

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 灵神：（答案）不明确但是终点（边界）明确，所以逆向思维！
     */
    class Solution {

        int[][] heights;
        int x, y;
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            this.heights = heights;
            x = heights.length;
            y = heights[0].length;
            boolean[][] po = new boolean[x][y]; // 太平洋
            boolean[][] ao = new boolean[x][y]; // 大西洋
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < x; i++) dfs(i, 0, 0, po);
            for (int i = 0; i < y; i++) dfs(0, i, 0, po);
            for (int i = 0; i < x; i++) dfs(i, y - 1, 0, ao);
            for (int i = 0; i < y; i++) dfs(x - 1, i, 0, ao);
            for (int i = 0; i < x; i++)
                for (int j = 0; j < y; j++)
                    if (po[i][j] & ao[i][j])
                        res.add(Stream.of(i, j).collect(Collectors.toList()));
            return res;
        }

        public void dfs(int i, int j, int v, boolean[][] vis) {
            if (i < 0 || j < 0 || i >= x || j >= y || heights[i][j] < v || vis[i][j]) return;
            vis[i][j] = true;
            for (int[] d : dir) dfs(i + d[0], j + d[1], heights[i][j], vis);
        }
    }

    /**
     * 普通思维，每次都重新刷新标记数组vis然后进行dfs，O(m^2*n^2)，勉强能过
     */
    class Solution_normal {

        int[][] heights;
        int x, y;
        boolean[][] vis;
        // boolean[][][] mem; // mem是作为记忆化节省时间，但效果极其有限
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            this.heights = heights;
            x = heights.length;
            y = heights[0].length;
            // mem = new boolean[x][y][3];
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    vis = new boolean[x][y];
                    boolean[] f = dfs(i, j, heights[i][j]);
                    // mem[i][j][0] = true;
                    // mem[i][j][1] = f[0];
                    // mem[i][j][2] = f[1];
                    if (f[0] & f[1]) res.add(Stream.of(i, j).collect(Collectors.toList()));
                }
            }
            return res;
        }

        public boolean[] dfs(int i, int j, int v) {
            if (i < 0 || j < 0) return new boolean[]{true, false};
            if (i >= x || j >= y) return new boolean[]{false, true};
            if (heights[i][j] > v) return new boolean[]{false, false};
            // if (mem[i][j][0]) return new boolean[]{mem[i][j][1], mem[i][j][2]};
            if (vis[i][j]) return new boolean[]{false, false};
            vis[i][j] = true;
            boolean[] res = {false, false};
            for (int[] d : dir) {
                boolean[] t = dfs(i + d[0], j + d[1], heights[i][j]);
                res[0] |= t[0];
                res[1] |= t[1];
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}