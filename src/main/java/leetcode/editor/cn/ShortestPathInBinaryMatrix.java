////给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
////
//// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述
//要求
////： 
////
//// 
//// 路径途经的所有单元格都的值都是 0 。 
//// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
//// 
////
//// 畅通路径的长度 是该路径途经的单元格总数。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：grid = [[0,1],[1,0]]
////输出：2
//// 
////
//// 示例 2： 
////
//// 
////输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
////输出：4
//// 
////
//// 示例 3： 
////
//// 
////输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
////输出：-1
//// 
////
//// 
////
//// 提示： 
////
//// 
//// n == grid.length 
//// n == grid[i].length 
//// 1 <= n <= 100 
//// grid[i][j] 为 0 或 1 
//// 
//// Related Topics 广度优先搜索 数组 矩阵 👍 204 👎 0
//


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;1091
 * <p>
 * Name：二进制矩阵中的最短路径
 *
 * @author Yuri
 * @since 2022-06-28 16:29:44
 */
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();
        int ans = solution.shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}});
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Point {
        int x, y, val;

        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            boolean[][] sign = new boolean[n][n];
            List<Point> points = new ArrayList<>();
            if (grid[0][0] == 0) {
                Point initialPoint = new Point(0, 0, 1);
                points.add(initialPoint);
            }
            sign[0][0] = true;
            while (!points.isEmpty()) {
                Point point = points.remove(0);
                if (point.getX() == n - 1 && point.getY() == n - 1) {
                    return point.getVal();
                }
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        int x = point.getX() + i;
                        int y = point.getY() + j;
                        if (x >= 0 && x < n && y >= 0 && y < n && !sign[x][y] && grid[x][y] == 0) {
                            points.add(new Point(x, y, point.getVal() + 1));
                            sign[x][y] = true;
                        }
                    }
                }

            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}