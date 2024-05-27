//在给定的网格中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。 
//
// 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 输入：[[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 438 👎 0


/*
 * Id：994
 * Name：腐烂的橘子
 * Date：2021-10-27 10:09:07
 */
package problems.leetcode.editor.cn;

import cn.hutool.core.lang.Pair;
import java.util.*;

public class RottingOranges {
    public static void main(String[] args) {
        Solution solution = new RottingOranges().new Solution();
        int[][] array = new int[][]{{0, 2}};
        solution.orangesRotting(array);
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {
            int x = grid.length, y = grid[0].length;
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            Deque<Pair<Integer, Integer>> q = new LinkedList<>();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (grid[i][j] == 2) q.add(new Pair<>(i * y + j, 0));
                }
            }
            Integer value = 0;
            while (!q.isEmpty()) {
                Pair<Integer, Integer> p = q.poll();
                Integer position = p.getKey();
                value = p.getValue();
                int i = position / y, j = position % y;
                for (int[] d : dir) {
                    int a = i + d[0], b = j + d[1];
                    if (a >= 0 && a < x && b >= 0 && b < y && grid[a][b] == 1) {
                        grid[a][b] =0;
                        q.add(new Pair<>(a * y + b, value + 1));
                    }
                }
            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (grid[i][j] == 1) return -1;
                }
            }
            return value;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 