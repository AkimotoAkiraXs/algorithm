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
package leetcode.editor.cn;

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
            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();
            int m = grid.length;
            int n = grid[0].length;
            int res = 0, sum = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        int pos = i * n + j;
                        queue.add(pos);
                        map.put(pos, 0);
                    } else if (grid[i][j] == 1) {
                        sum++;
                    }
                }
            }
            /*
            可以用数组+for循环进行上下左右移动的模拟
            int[] dr = new int[]{-1, 0, 1, 0};
            int[] dc = new int[]{0, -1, 0, 1};
            */
            while (!queue.isEmpty()) {
                int num = queue.poll();
                int i = num / n;
                int j = num % n;
                int pos = i * n + j;
                if (i > 0 && grid[i - 1][j] == 1) {
                    int np = (i - 1) * n + j;
                    grid[i - 1][j] = 2;
                    queue.add(np);
                    res = map.get(pos) + 1;
                    map.put(np, res);
                    sum--;
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    int np = i * n + j - 1;
                    grid[i][j - 1] = 2;
                    queue.add(np);
                    res = map.get(pos) + 1;
                    map.put(np, res);
                    sum--;
                }
                if (i < m - 1 && grid[i + 1][j] == 1) {
                    int np = (i + 1) * n + j;
                    grid[i + 1][j] = 2;
                    queue.add(np);
                    res = map.get(pos) + 1;
                    map.put(np, res);
                    sum--;
                }
                if (j < n - 1 && grid[i][j + 1] == 1) {
                    int np = i * n + j + 1;
                    grid[i][j + 1] = 2;
                    queue.add(np);
                    res = map.get(pos) + 1;
                    map.put(np, res);
                    sum--;
                }
            }
            if (sum == 0) return res;
            else return -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 