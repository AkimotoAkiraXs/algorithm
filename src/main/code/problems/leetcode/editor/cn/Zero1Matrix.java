//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 104 
// 1 <= m * n <= 104 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 
// 👍 511 👎 0


/*
 * Id：542
 * Name：01 矩阵
 * Date：2021-09-30 09:57:17
 */
package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix().new Solution();
        int[][] nums = new int[][]{{0}, {1}};
        solution.updateMatrix(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // bfs
        public int[][] updateMatrix_bfs(int[][] mat) {
            int x = mat.length, y = mat[0].length;
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int[][] res = new int[x][y];
            for (int i = 0; i < x; i++) Arrays.fill(res[i], Integer.MAX_VALUE);
            Deque<Integer> q = new LinkedList<>();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (mat[i][j] == 0) {
                        q.add(i * y + j);
                        res[i][j] = 0;
                    }
                }
            }

            while (!q.isEmpty()) {
                Integer position = q.poll();
                int i = position / y, j = position % y;
                for (int[] d : dir) {
                    int a = i + d[0], b = j + d[1];
                    if (a >= 0 && a < x && b >= 0 && b < y && mat[a][b] == 1) {
                        mat[a][b] = 0;
                        res[a][b] = res[i][j] + 1;
                        q.add(a * y + b);
                    }
                }
            }
            return res;
        }

        // dp
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int[][] dis = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dis[i], Integer.MAX_VALUE - 10);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) dis[i][j] = 0;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i > 0) dis[i][j] = Math.min(dis[i][j], dis[i - 1][j] + 1);
                    if (j > 0) dis[i][j] = Math.min(dis[i][j], dis[i][j - 1] + 1);
                }
            }

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i + 1 < m) dis[i][j] = Math.min(dis[i][j], dis[i + 1][j] + 1);
                    if (j + 1 < n) dis[i][j] = Math.min(dis[i][j], dis[i][j + 1] + 1);
                }
            }
            return dis;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 